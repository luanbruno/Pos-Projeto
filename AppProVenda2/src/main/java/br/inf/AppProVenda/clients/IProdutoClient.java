package br.inf.AppProVenda.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.inf.AppProVenda.modal.domain.Produto;

@FeignClient(url = "localhost:8083/api/produto", name = "produtoClient")
public interface IProdutoClient {

	@GetMapping(value = "/listar")
	public List<Produto> obterLista();

	@GetMapping(value = "/{idUser}/listar")
	public List<Produto> obterLista(@PathVariable Integer idUser);

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id);
	
	@GetMapping(value = "/qtde")
	public Long obterQtde();

	@GetMapping(value = "/{id}")
	public Produto obterPorId(@PathVariable Integer id);
}