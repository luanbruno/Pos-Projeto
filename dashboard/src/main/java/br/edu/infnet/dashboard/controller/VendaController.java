package br.edu.infnet.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.service.VendaService;

@Controller
public class VendaController {
	
	@Autowired
	private VendaService vendaService;

	@GetMapping(value = "/vendas")
	public String obterLista(Model model) {
		
		model.addAttribute("listagem", vendaService.obterLista());
		
		return "lista/vendas";
	}
}
