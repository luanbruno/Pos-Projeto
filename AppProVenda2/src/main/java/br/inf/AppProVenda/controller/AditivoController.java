package br.inf.AppProVenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.inf.AppProVenda.modal.domain.Aditivo;
import br.inf.AppProVenda.modal.domain.Usuario;
import br.inf.AppProVenda.modal.service.AditivoService;
import br.inf.AppProVenda.modal.service.ProdutoService;

@Controller
public class AditivoController {
	
	@Autowired
	private AditivoService aditivoService;
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/aditivo")
	public String telaCadastro() {
		
		return "aditivo/cadastro";
	}
	
	@GetMapping(value = "/aditivos")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("lista", aditivoService.obterLista(usuario));
		
		return "aditivo/lista";
	}

	@PostMapping(value = "/aditivo/incluir")
	public String incluir(Model model, Aditivo aditivo, @SessionAttribute("user") Usuario usuario) {

		aditivo.setUsuario(usuario);

		aditivoService.incluir(aditivo);
		
		model.addAttribute("mensagem", "O aditivo " + aditivo.getComposicao() + " foi cadastrado com sucesso!!!");
		
		return telaLista(model, usuario);
	}

	@GetMapping(value = "/aditivo/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Aditivo aditivo = aditivoService.obterPorId(id);	
		
		try {
			produtoService.excluir(id);

			model.addAttribute("mensagem", "O aditivo "+  aditivo.getComposicao() +" foi removida com sucesso!!!");		
		} catch (Exception e) {
			model.addAttribute("mensagem", "Impossível remover o aditivo "+aditivo.getComposicao()+"!!! Ela está associada a uma venda.");
		}	
		
		return telaLista(model, usuario);
	}
}
