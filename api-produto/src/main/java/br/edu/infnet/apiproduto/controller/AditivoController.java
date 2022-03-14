package br.edu.infnet.apiproduto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apiproduto.model.domain.Aditivo;
import br.edu.infnet.apiproduto.model.service.AditivoService;

@RestController
@RequestMapping("/api/produto")
public class AditivoController {
	
	@Autowired
	private AditivoService aditivoService;
	
	@GetMapping(value = "/{idUser}/listar/aditivo")
	public List<Aditivo> obterLista(@PathVariable Integer idUser) {
		return aditivoService.obterLista(idUser);
	}

	@GetMapping(value = "/listar/aditivo")
	public List<Aditivo> obterLista() {
		return aditivoService.obterLista();
	}

	@PostMapping(value = "/incluir/aditivo")
	public void inserir(@RequestBody Aditivo aditivo) {
		aditivoService.incluir(aditivo);
	}

	@GetMapping(value = "/{id}/aditivo")
	public Aditivo obterPorId(@PathVariable Integer id) {
		return aditivoService.obterPorId(id);
	}
	
	@GetMapping(value = "/qtde/aditivo")
	public Long obterQtde() {
		return null;
	}
	
}