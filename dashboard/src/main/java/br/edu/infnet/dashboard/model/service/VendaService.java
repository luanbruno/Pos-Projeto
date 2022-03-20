package br.edu.infnet.dashboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.clients.IVendaClient;
import br.edu.infnet.dashboard.model.domain.Venda;

@Service
public class VendaService {
	
	@Autowired
	private IVendaClient vendaClient;
	
	public List<Venda> obterLista() {
		return vendaClient.obterLista();
	}
	
	public long obterQuantidade() {
		return vendaClient.obterQuantidade();
	}
}