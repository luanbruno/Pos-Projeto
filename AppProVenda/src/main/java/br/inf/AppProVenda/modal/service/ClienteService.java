package br.inf.AppProVenda.modal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.inf.AppProVenda.clients.IClienteClient;
import br.inf.AppProVenda.modal.domain.Cliente;
import br.inf.AppProVenda.modal.domain.Usuario;

@Service
public class ClienteService {
	

	@Autowired
	private IClienteClient clienteClient;

	public Long obterQtde() {
		return clienteClient.obterQtde();
	}

	public List<Cliente> obterLista(){

		return clienteClient.obterLista();
	}
	
	public List<Cliente> obterLista(Usuario usuario){

		return clienteClient.obterLista(usuario.getId());
	}

	public void incluir(Cliente cliente) {

		clienteClient.incluir(cliente);		
	}
	
	public void excluir(Integer id) {

		clienteClient.excluir(id);
	}
	
	public Cliente obterPorId(Integer id) {

		return clienteClient.obterPorId(id);
	}

}