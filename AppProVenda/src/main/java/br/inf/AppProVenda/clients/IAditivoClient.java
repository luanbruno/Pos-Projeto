package br.inf.AppProVenda.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.inf.AppProVenda.modal.domain.Aditivo;

@FeignClient(url = "localhost:8083/api/produto", name = "aditivoClient")
public interface IAditivoClient {

	@PostMapping(value = "/incluir/aditivo")
	public void incluir(@RequestBody Aditivo aditivo);

	@GetMapping(value = "/listar/aditivo")
	public List<Aditivo> obterLista();

	@GetMapping(value = "/{idUser}/listar/aditivo")
	public List<Aditivo> obterLista(@PathVariable Integer idUser);
	
	@GetMapping(value = "/qtde/aditivo")
	public Long obterQtde();

	@GetMapping(value = "/{id}/aditivo")
	public Aditivo obterPorId(@PathVariable Integer id);
}