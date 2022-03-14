package br.inf.AppProVenda.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.inf.AppProVenda.modal.domain.Lubrificante;

@FeignClient(url = "localhost:8083/api/produto", name = "lubrificanteClient")
public interface ILubrificanteClient {

	@PostMapping(value = "/incluir/lubrificante")
	public void incluir(@RequestBody Lubrificante lubrificante);

	@GetMapping(value = "/listar/lubrificante")
	public List<Lubrificante> obterLista();

	@GetMapping(value = "/{idUser}/listar/lubrificante")
	public List<Lubrificante> obterLista(@PathVariable Integer idUser);
	
	@GetMapping(value = "/qtde/lubrificante")
	public Long obterQtde();

	@GetMapping(value = "/{id}/lubrificante")
	public Lubrificante obterPorId(@PathVariable Integer id);
}