package br.edu.infnet.apipedido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apipedido.model.domain.Venda;
import br.edu.infnet.apipedido.model.service.VendaService;

@RestController
@RequestMapping("/api/venda")
public class VendaController {
	
	@Autowired
	private VendaService vendaService;

	@GetMapping(value = "/listar")
	public List<Venda> obterLista() {
		return vendaService.obterLista();
	}
	
//	@GetMapping(value = "/{idUser}/listar")
//	public List<Venda> obterLista(@PathVariable Integer idUser){
//		return vendaService.obterLista(idUser);
//	}	

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Venda venda) {
		vendaService.incluir(venda);
	}

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		vendaService.excluir(id);
	}
	
	@GetMapping(value = "/qtde")
	public Long obterQtde() {
		return vendaService.obterQtde();
	}
	
	@GetMapping(value = "/{id}/obter")
	public Venda obterPorId(@PathVariable Integer id) {
		return vendaService.obterPorId(id);
	}	
}