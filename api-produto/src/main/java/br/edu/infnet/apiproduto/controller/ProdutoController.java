package br.edu.infnet.apiproduto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apiproduto.model.domain.Produto;
import br.edu.infnet.apiproduto.model.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/{idUser}/listar")
	public List<Produto> obterLista(@PathVariable Integer idUser) {
		return produtoService.obterLista(idUser);
	}

	@GetMapping(value = "/listar")
	public List<Produto> obterLista() {
		return produtoService.obterLista();
	}
	
	@PostMapping(value = "/incluir")
	public void inserir(@RequestBody Produto produto) {
		produtoService.incluir(produto);
	}

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		produtoService.excluir(id);
	}
	
	@GetMapping(value = "/{id}")
	public Produto obterPorId(@PathVariable Integer id) {
		return produtoService.obterPorId(id);
	}
	@GetMapping(value = "/qtde")
	public Long obterQtde() {
		return produtoService.obterQtde();
	}
}