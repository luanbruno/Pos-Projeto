package br.inf.AppProVenda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.inf.AppProVenda.modal.domain.Produto;
import br.inf.AppProVenda.modal.domain.Usuario;
import br.inf.AppProVenda.modal.domain.Venda;
import br.inf.AppProVenda.modal.service.ClienteService;
import br.inf.AppProVenda.modal.service.ProdutoService;
import br.inf.AppProVenda.modal.service.VendaService;

@Controller
public class VendaController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private VendaService vendaService;

	@GetMapping(value = "/venda")
	public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("clientes",clienteService.obterLista(usuario));
		
		model.addAttribute("produtos",produtoService.obterLista(usuario));
		
		return "venda/cadastro";
	}
	
	@GetMapping(value = "/vendas")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("lista", vendaService.obterLista(usuario));
		
		return "venda/lista";
	}

	@PostMapping(value = "/venda/incluir")
	public String incluir(Model model, Venda venda, @RequestParam String[] produtosId, @SessionAttribute("user") Usuario usuario) {
		
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		for (String id : produtosId) {
			
			int meuId = Integer.valueOf(id);
			
			Produto produto = produtoService.obterPorId(meuId);
			
			produtos.add(produto);
			
		}
		
		venda.setProdutos(produtos);	
		
		venda.setUsuario(usuario);	
		
		vendaService.incluir(venda);

		model.addAttribute("mensagem", "A venda numero "+venda.getId()+" foi realizada com sucesso!!!");
		
		return telaLista(model, usuario);
	}

	@GetMapping(value = "/venda/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Venda venda = vendaService.obterPorId(id);		
		vendaService.excluir(id);

		model.addAttribute("mensagem", "A venda registrada na data"+venda.getData()+" foi removido com sucesso!!!");		
		
		return telaLista(model, usuario);
	}
}
