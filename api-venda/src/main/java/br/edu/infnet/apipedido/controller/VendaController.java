package br.edu.infnet.apipedido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apipedido.model.domain.Venda;
import br.edu.infnet.apipedido.model.service.VendaService;

@RestController
@RequestMapping("/api/venda")
public class VendaController {
	
	@Autowired
	private VendaService vendaService;

	@GetMapping(value = "/listarr")
	public List<Venda> obterLista() {
		return vendaService.obterLista();
	}
	
	@GetMapping(value = "/qtde")
	public long obterQuantidade() {
		return vendaService.obterQuantidade();
	}	
}