package br.edu.infnet.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.domain.Usuario;
import br.edu.infnet.dashboard.model.service.AditivoService;
import br.edu.infnet.dashboard.model.service.BateriaService;
import br.edu.infnet.dashboard.model.service.LogService;
import br.edu.infnet.dashboard.model.service.LubrificanteService;
import br.edu.infnet.dashboard.model.service.UsuarioService;
import br.edu.infnet.dashboard.model.service.VendaService;

@Controller
public class DashboardController {
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private VendaService vendaService;
	
	@Autowired
	private AditivoService aditivoService;

	@Autowired
	private BateriaService bateriaService;

	@Autowired
	private LubrificanteService LubrificanteService;

	@Autowired
	private LogService logService;

	@GetMapping(value = "/")
	public String index(Model model) {

		//produtos e vendas por usuário
		List<Usuario> usuarios = usuarioService.obterLista();		
		model.addAttribute("vendasPorUsuario", usuarios);		
		model.addAttribute("produtosPorUsuario", usuarios);
		
		//quantidade de vendas
		model.addAttribute("qtdeVendas", vendaService.obterQuantidade());
		
		//valor de vendas dos produtos
		model.addAttribute("valorVendaAditivo", aditivoService.calcularValorVenda());
		model.addAttribute("valorVendaBateria", bateriaService.calcularValorVenda());
		model.addAttribute("valorVendaLubrificante", LubrificanteService.calcularValorVenda());

		//recuperar o log
		model.addAttribute("listaLog", logService.obterLista());
		model.addAttribute("qtdeLog", logService.obterQuantidade());
		
		return "index";
	}
}