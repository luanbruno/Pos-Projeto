package br.edu.infnet.apiproduto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apiproduto.model.domain.Lubrificante;
import br.edu.infnet.apiproduto.model.service.LubrificanteService;

@RestController
@RequestMapping("/api/produto")
public class LubrificanteController {
	
	@Autowired
	private LubrificanteService lubrificanteService;
	
	@GetMapping(value = "/{idUser}/listar/lubrificante")
	public List<Lubrificante> obterLista(@PathVariable Integer idUser) {
		return lubrificanteService.obterLista(idUser);
	}

	@GetMapping(value = "/listar/lubrificante")
	public List<Lubrificante> obterLista() {
		return lubrificanteService.obterLista();
	}

	@PostMapping(value = "/incluir/lubrificante")
	public void inserir(@RequestBody Lubrificante lubrificante) {
		lubrificanteService.incluir(lubrificante);
	}

	@GetMapping(value = "/{id}/lubrificante")
	public Lubrificante obterPorId(@PathVariable Integer id) {
		return lubrificanteService.obterPorId(id);
	}
	
	@GetMapping(value = "/qtde/lubrificante")
	public Long obterQtde() {
		return lubrificanteService.obterQtde();
	}
	
}