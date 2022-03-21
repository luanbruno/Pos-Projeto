package br.inf.AppProVenda.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.inf.AppProVenda.modal.domain.Cliente;

@FeignClient(url = "localhost:8084/api/cliente", name = "clienteClient")
public interface IClienteClient {

	@GetMapping(value = "/listar")
	public List<Cliente> obterLista();

	@GetMapping(value = "/{idUser}/listar")
	public List<Cliente> obterLista(@PathVariable Integer idUser);

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Cliente cliente);
	
	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id);
	
	@GetMapping(value = "/qtde")
	public Long obterQtde();

	@GetMapping(value = "/{id}/obter")
	public Cliente obterPorId(@PathVariable Integer id);	
}