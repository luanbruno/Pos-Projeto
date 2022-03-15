package br.inf.AppProVenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.inf.AppProVenda.modal.domain.Produto;
import br.inf.AppProVenda.modal.domain.Usuario;
import br.inf.AppProVenda.modal.service.ProdutoService;

@Controller
public class ProdutoController {
	

	@Autowired
	private ProdutoService produtoService;
	
	
	@GetMapping(value = "/produtos")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("lista", produtoService.obterLista(usuario));
		
		return "produto/lista";
	}


	@GetMapping(value = "/produto/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Produto produto = produtoService.obterPorId(id);	
		
		try {
			produtoService.excluir(id);

			model.addAttribute("mensagem", "O produto "+produto.getNome() +" foi removida com sucesso!!!");		
		} catch (Exception e) {
			model.addAttribute("mensagem", "Impossível remover o produto "+produto.getNome()+"!!! Ela está associada a uma venda.");
		}	
		
		return telaLista(model, usuario);
	}
}
