package br.edu.infnet.dashboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.clients.IPedidoClient;
import br.edu.infnet.dashboard.model.domain.Pedido;

@Service
public class PedidoService {
	
	@Autowired
	private IPedidoClient pedidoClient;
	
	public List<Pedido> obterLista() {
		return pedidoClient.obterLista();
	}
	
	public long obterQuantidade() {
		return pedidoClient.obterQuantidade();
	}		
}
