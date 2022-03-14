package br.edu.infnet.dashboard.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.domain.Pedido;

@FeignClient(url = "localhost:8082/api/pedido", name = "pedidoClient")
public interface IPedidoClient {

	@GetMapping(value = "/listar")
	public List<Pedido> obterLista();

	@GetMapping(value = "/qtde")
	public long obterQuantidade();
}