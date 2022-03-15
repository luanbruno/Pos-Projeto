package br.inf.AppProVenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.inf.AppProVenda.modal.domain.Lubrificante;
import br.inf.AppProVenda.modal.domain.Usuario;
import br.inf.AppProVenda.modal.service.LubrificanteService;
import br.inf.AppProVenda.modal.service.ProdutoService;

@Controller
public class LubrificanteController {
	
	@Autowired
	private LubrificanteService lubrificanteService;
	@Autowired
	private ProdutoService produtoService;
	@GetMapping(value = "/lubrificante")
	public String telaCadastro() {
		
		return "lubrificante/cadastro";
	}
	
	@GetMapping(value = "/lubrificantes")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("lista", lubrificanteService.obterLista(usuario));
		
		return "lubrificante/lista";
	}

	@PostMapping(value = "/lubrificante/incluir")
	public String incluir(Model model, Lubrificante lubrificante, @SessionAttribute("user") Usuario usuario) {

		lubrificante.setUsuario(usuario);

		lubrificanteService.incluir(lubrificante);
		model.addAttribute("mensagem", "O lubrificante para " + lubrificante.getTipo() + " foi cadastrado com sucesso!!!");
		return telaLista(model, usuario);
	}

	@GetMapping(value = "/lubrificante/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Lubrificante lubrificante = lubrificanteService.obterPorId(id);	
		
		try {
			produtoService.excluir(id);

			model.addAttribute("mensagem", "O lubrificante de "+  lubrificante.getTipo() +" foi removida com sucesso!!!");		
		} catch (Exception e) {
			model.addAttribute("mensagem", "Impossível remover o lubrificante para "+lubrificante.getTipo()+"!!! Ela está associada a uma venda.");
		}	
		
		return telaLista(model, usuario);
	}
}
