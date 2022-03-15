package br.inf.AppProVenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.inf.AppProVenda.modal.domain.Cliente;
import br.inf.AppProVenda.modal.domain.Endereco;
import br.inf.AppProVenda.modal.domain.Usuario;
import br.inf.AppProVenda.modal.service.ClienteService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "/cliente")
	public String telaCadastro() {

		return "cliente/cadastro";
	}
	
	@GetMapping(value = "/clientes")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("lista", clienteService.obterLista(usuario));
		
		return "cliente/lista";
	}

	@PostMapping(value = "/cliente/incluir")
	public String incluir(Model model, Cliente cliente,Endereco endereco, @SessionAttribute("user") Usuario usuario) {
		
		cliente.setEndereco(endereco);
		
		cliente.setUsuario(usuario);
		
		clienteService.incluir(cliente);
		
		model.addAttribute("mensagem", "O cliente "+cliente.getNome()+" foi cadastrado com sucesso!!!");
		
		return telaLista(model, usuario);
	}

	@GetMapping(value = "/cliente/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Cliente cliente = clienteService.obterPorId(id);		
	
		try {
			clienteService.excluir(id);
			model.addAttribute("mensagem", "O cliente "+cliente.getNome()+" foi removido com sucesso!!!");		
		} catch (Exception e) {
			model.addAttribute("mensagem", "Impossível remover o cliente "+cliente.getNome()+"!!! Ele está associado a um pedido.");
		}
		return telaLista(model, usuario);
	}
}
