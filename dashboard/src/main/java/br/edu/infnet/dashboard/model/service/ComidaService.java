package br.edu.infnet.dashboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.clients.IProdutoClient;
import br.edu.infnet.dashboard.model.domain.Comida;

@Service
public class ComidaService {
	
	@Autowired
	private IProdutoClient produtoClient;
	
	public List<Comida> obterLista() {
		return produtoClient.obterComidaLista();
	}
	
	public float calcularValorVenda() {
		
		float valorVenda = 0;
		
		for(Comida comida : produtoClient.obterComidaLista()) {
			valorVenda = valorVenda + comida.calcularValorVenda();
		}
		
		return valorVenda;
	}
}