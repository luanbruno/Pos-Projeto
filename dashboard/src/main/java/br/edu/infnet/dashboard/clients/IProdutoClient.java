package br.edu.infnet.dashboard.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.domain.Aditivo;
import br.edu.infnet.dashboard.model.domain.Bateria;
import br.edu.infnet.dashboard.model.domain.Lubrificante;
import br.edu.infnet.dashboard.model.domain.Produto;

@FeignClient(url = "localhost:8083/api/produto", name = "produtoClient")
public interface IProdutoClient {

	@GetMapping(value = "/listar")
	public List<Produto> obterLista();
	
	@GetMapping(value = "/listar/aditivo")
	public List<Aditivo> obterAditivoLista();

	@GetMapping(value = "/listar/bateria")
	public List<Bateria> obterBateriaLista();
	
	@GetMapping(value = "/listar/lubrificante")
	public List<Lubrificante> obterLubrificanteLista();
}