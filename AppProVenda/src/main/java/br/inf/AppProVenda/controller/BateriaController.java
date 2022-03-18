package br.inf.AppProVenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.inf.AppProVenda.modal.domain.Bateria;
import br.inf.AppProVenda.modal.domain.Usuario;
import br.inf.AppProVenda.modal.service.BateriaService;
import br.inf.AppProVenda.modal.service.ProdutoService;

@Controller
public class BateriaController {
	
	@Autowired
	private BateriaService bateriaService;
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/bateria")
	public String telaCadastro() {
		
		return "bateria/cadastro";
	}
	
	@GetMapping(value = "/baterias")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("lista", bateriaService.obterLista(usuario));
		
		return "bateria/lista";
	}

	@PostMapping(value = "/bateria/incluir")
	public String incluir(Model model, Bateria bateria, @SessionAttribute("user") Usuario usuario) {

		bateria.setUsuario(usuario);

		bateriaService.incluir(bateria);
		
		model.addAttribute("mensagem", "A bateria para " + bateria.getTipo() + " foi cadastrado com sucesso!!!");
		return telaLista(model, usuario);
	}

	@GetMapping(value = "/bateria/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Bateria bateria = bateriaService.obterPorId(id);	
		
		try {
			produtoService.excluir(id);

			model.addAttribute("mensagem", "A bateria de "+  bateria.getTipo() +"  volt foi removida com sucesso!!!");		
		} catch (Exception e) {
			model.addAttribute("mensagem", "Impossível remover A bateria de "+bateria.getTipo()+"volt !!! Ela está associada a uma venda.");
		}	
		
		return telaLista(model, usuario);
	}
}
