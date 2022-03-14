package br.edu.infnet.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.domain.Usuario;
import br.edu.infnet.dashboard.model.service.BebidaService;
import br.edu.infnet.dashboard.model.service.ComidaService;
import br.edu.infnet.dashboard.model.service.LogService;
import br.edu.infnet.dashboard.model.service.PedidoService;
import br.edu.infnet.dashboard.model.service.SobremesaService;
import br.edu.infnet.dashboard.model.service.UsuarioService;

@Controller
public class DashboardController {
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private BebidaService bebidaService;

	@Autowired
	private ComidaService comidaService;

	@Autowired
	private SobremesaService sobremesaService;

	@Autowired
	private LogService logService;

	@GetMapping(value = "/")
	public String index(Model model) {

		//produtos e pedidos por usuário
		List<Usuario> usuarios = usuarioService.obterLista();		
		model.addAttribute("pedidosPorUsuario", usuarios);		
		model.addAttribute("produtosPorUsuario", usuarios);
		
		//quantidade de pedidos
		model.addAttribute("qtdePedidos", pedidoService.obterQuantidade());
		
		//valor de vendos dos produtos
		model.addAttribute("valorVendaBebida", bebidaService.calcularValorVenda());
		model.addAttribute("valorVendaComida", comidaService.calcularValorVenda());
		model.addAttribute("valorVendaSobremsa", sobremesaService.calcularValorVenda());

		//recuperar o log
		model.addAttribute("listaLog", logService.obterLista());
		model.addAttribute("qtdeLog", logService.obterQuantidade());
		
		return "index";
	}
}