package br.inf.AppProVenda.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.inf.AppProVenda.modal.domain.Bateria;

@FeignClient(url = "localhost:8083/api/produto", name = "bateriaClient")
public interface IBateriaClient {

	@PostMapping(value = "/incluir/bateria")
	public void incluir(@RequestBody Bateria bateria);

	@GetMapping(value = "/listar/bateria")
	public List<Bateria> obterLista();

	@GetMapping(value = "/{idUser}/listar/bateria")
	public List<Bateria> obterLista(@PathVariable Integer idUser);
	
	@GetMapping(value = "/qtde/bateria")
	public Long obterQtde();

	@GetMapping(value = "/{id}/bateria")
	public Bateria obterPorId(@PathVariable Integer id);
}