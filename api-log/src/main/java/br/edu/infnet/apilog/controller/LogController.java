package br.edu.infnet.apilog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apilog.model.domain.Log;
import br.edu.infnet.apilog.model.service.LogService;

@RestController
@RequestMapping("/api/log")
public class LogController {
	
	@Autowired
	private LogService logService;

	@GetMapping(value = "/listar")
	public List<Log> obterLista() {
		return logService.obterLista();
	}

	@GetMapping(value = "/qtde")
	public Long obterQuantidade() {
		return logService.obterQtde();
	}

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Log log) {		
		logService.incluir(log);
	}

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		logService.excluir(id);
	}
}