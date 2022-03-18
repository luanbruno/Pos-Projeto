package br.inf.AppProVenda.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.inf.AppProVenda.modal.service.AditivoService;
import br.inf.AppProVenda.modal.service.BateriaService;
import br.inf.AppProVenda.modal.service.ClienteService;
import br.inf.AppProVenda.modal.service.LubrificanteService;
import br.inf.AppProVenda.modal.service.ProdutoService;
import br.inf.AppProVenda.modal.service.UsuarioService;
import br.inf.AppProVenda.modal.service.VendaService;

@Controller
public class AppController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private AditivoService aditivoService;
	
	@Autowired
	private BateriaService bateriaService;
	
	@Autowired
	private LubrificanteService lubrificanteService;
	
	@Autowired
	private VendaService VendaService;


	@GetMapping(value = "/home")
	public String telahome() {
		
		return "home";
	}
	
	@GetMapping(value = "/app")
	public String telaApp(Model model) {
		
		Map<String, Long> mapa = new HashMap<String, Long>();
		mapa.put("Usuários", usuarioService.obterQtde());
		mapa.put("Clientes", clienteService.obterQtde());
		mapa.put("Produto", produtoService.obterQtde());
		mapa.put("Lubrificante", lubrificanteService.obterQtde());
		mapa.put("Aditivo", aditivoService.obterQtde());
		mapa.put("Bateria", bateriaService.obterQtde());
		mapa.put("Venda",VendaService.obterQtde());
		
		
		model.addAttribute("myMap", mapa);
		
		return "app";
	}
}
