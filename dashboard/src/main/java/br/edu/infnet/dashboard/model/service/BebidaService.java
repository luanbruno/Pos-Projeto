package br.edu.infnet.dashboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.clients.IProdutoClient;
import br.edu.infnet.dashboard.model.domain.Bebida;

@Service
public class BebidaService {
	
	@Autowired
	private IProdutoClient produtoClient;
	
	public List<Bebida> obterLista() {
		return produtoClient.obterBebidaLista();
	}
	
	public float calcularValorVenda() {
		
		float valorVenda = 0;
		
		for(Bebida bebida : produtoClient.obterBebidaLista()) {
			valorVenda = valorVenda + bebida.calcularValorVenda();
		}
		
		return valorVenda;
	}
}