package br.edu.infnet.dashboard.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.domain.Venda;

@FeignClient(url = "localhost:8082/api/venda", name = "vendaClient")
public interface IVendaClient {

	@GetMapping(value = "/listar")
	public List<Venda> obterLista();

	@GetMapping(value = "/qtde")
	public long obterQuantidade();
}