package br.edu.infnet.dashboard.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.domain.Usuario;

@FeignClient(url = "localhost:8081/api/usuario", name = "usuarioClient")
public interface IUsuarioClient {

	@GetMapping(value = "/listar")
	public List<Usuario> obterLista();
}