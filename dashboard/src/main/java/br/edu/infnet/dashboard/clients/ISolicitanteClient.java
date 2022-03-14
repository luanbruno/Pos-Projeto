package br.edu.infnet.dashboard.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.domain.Solicitante;

@FeignClient(url = "localhost:8084/api/solicitante", name = "solicitanteClient")
public interface ISolicitanteClient {

	@GetMapping(value = "/listar")
	public List<Solicitante> obterLista();
}