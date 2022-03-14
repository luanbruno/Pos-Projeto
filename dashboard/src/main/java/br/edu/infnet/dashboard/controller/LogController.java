package br.edu.infnet.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.dashboard.model.service.LogService;

@Controller
public class LogController {
	
	@Autowired
	private LogService logService;

	@GetMapping(value = "/log/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		logService.excluir(id);

		return "redirect:/";
	}
	
}
