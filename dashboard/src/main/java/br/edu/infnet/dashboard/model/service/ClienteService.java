package br.edu.infnet.dashboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.model.domain.Cliente;

@Service
public class ClienteService {
	
	@Autowired
	public IClienteClient clienteClient; 
	
	public List<Cliente> obterLista(){
		return clienteClient.obterLista();
	}
}