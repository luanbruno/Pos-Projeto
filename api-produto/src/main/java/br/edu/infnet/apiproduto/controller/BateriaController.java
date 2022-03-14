package br.edu.infnet.apiproduto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apiproduto.model.domain.Bateria;
import br.edu.infnet.apiproduto.model.service.BateriaService;

@RestController
@RequestMapping("/api/produto")
public class BateriaController {
	
	@Autowired
	private BateriaService bateriaService;
	
	@GetMapping(value = "/{idUser}/listar/bateria")
	public List<Bateria> obterLista(@PathVariable Integer idUser) {
		return bateriaService.obterLista(idUser);
	}

	@GetMapping(value = "/listar/bateria")
	public List<Bateria> obterLista() {
		return bateriaService.obterLista();
	}

	@PostMapping(value = "/incluir/bateria")
	public void inserir(@RequestBody Bateria bateria) {
		bateriaService.incluir(bateria);
	}

	@GetMapping(value = "/{id}/bateria")
	public Bateria obterPorId(@PathVariable Integer id) {
		return bateriaService.obterPorId(id);
	}
	
	@GetMapping(value = "/qtde/bateria")
	public Long obterQtde() {
		return null;
	}
	
}