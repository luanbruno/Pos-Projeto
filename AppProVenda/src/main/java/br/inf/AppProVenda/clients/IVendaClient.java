package br.inf.AppProVenda.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.inf.AppProVenda.modal.domain.Venda;

@FeignClient(url = "localhost:8082/api/venda", name = "vendaClient")
public interface IVendaClient {

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Venda venda);
	
	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id);
	
	@GetMapping(value = "/listar")
	public List<Venda> obterLista();

	@GetMapping(value = "/{idUser}/listar")
	public List<Venda> obterLista(@PathVariable Integer idUser);
	
	@GetMapping(value = "/qtde")
	public Long obterQtde();

	@GetMapping(value = "/{id}/obter")
	public Venda obterPorId(@PathVariable Integer id);	
}