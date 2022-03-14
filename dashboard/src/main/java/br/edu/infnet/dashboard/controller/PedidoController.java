package br.edu.infnet.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.exceptions.PesoInvalidoException;
import br.edu.infnet.dashboard.model.exceptions.ValorInvalidoException;
import br.edu.infnet.dashboard.model.service.PedidoService;

@Controller
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;

	@GetMapping(value = "/pedidos")
	public String obterLista(Model model) throws ValorInvalidoException, PesoInvalidoException {
		
		model.addAttribute("listagem", pedidoService.obterLista());
		
		return "lista/pedidos";
	}
}
