package br.edu.infnet.dashboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.clients.IProdutoClient;
import br.edu.infnet.dashboard.model.domain.Bateria;

@Service
public class BateriaService {
	
	@Autowired
	private IProdutoClient produtoClient;
	
	public List<Bateria> obterLista() {
		return produtoClient.obterBateriaLista();
	}
	
	public float calcularValorVenda() {
		
		float valorVenda = 0;
		
		for(Bateria bateria : produtoClient.obterBateriaLista()) {
			valorVenda = valorVenda + bateria.getValor();
		}
		
		return valorVenda;
	}
}