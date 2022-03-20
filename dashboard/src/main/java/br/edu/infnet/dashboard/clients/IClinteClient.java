package br.edu.infnet.dashboard.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.domain.Cliente;

@FeignClient(url = "localhost:8084/api/clinte", name = "clienteClient")
public interface IClinteClient {

	@GetMapping(value = "/listar")
	public List<Cliente> obterLista();
}