package br.edu.infnet.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.service.ClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "/clientes")
	public String obterLista(Model model) {
		
		model.addAttribute("listagem", clienteService.obterLista());
		
		return "lista/clientes";
	}
}