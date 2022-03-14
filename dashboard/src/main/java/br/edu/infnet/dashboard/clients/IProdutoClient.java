package br.edu.infnet.dashboard.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.domain.Bebida;
import br.edu.infnet.dashboard.model.domain.Comida;
import br.edu.infnet.dashboard.model.domain.Produto;

@FeignClient(url = "localhost:8083/api/produto", name = "produtoClient")
public interface IProdutoClient {

	@GetMapping(value = "/listar")
	public List<Produto> obterLista();
	
	@GetMapping(value = "/bebida/listar")
	public List<Bebida> obterBebidaLista();

	@GetMapping(value = "/comida/listar")
	public List<Comida> obterComidaLista();
}