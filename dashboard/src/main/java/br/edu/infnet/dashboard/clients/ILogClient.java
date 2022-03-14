package br.edu.infnet.dashboard.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.dashboard.model.domain.Log;

@FeignClient(url = "localhost:8085/api/log", name = "logClient")
public interface ILogClient {

	@GetMapping(value = "/listar")
	public List<Log> obterLista();

	@GetMapping(value = "/qtde")
	public Long obterQuantidade();

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Log log);

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id);
}