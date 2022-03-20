package br.edu.infnet.dashboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.clients.IProdutoClient;
import br.edu.infnet.dashboard.model.domain.Aditivo;

@Service
public class AditivoService {
	
	@Autowired
	private IProdutoClient produtoClient;
	
	public List<Aditivo> obterLista() {
		return produtoClient.obterAditivoLista();
	}
	
	public float calcularValorVenda() {
		
		float valorVenda = 0;
		
		for(Aditivo aditivo : produtoClient.obterAditivoLista()) {
			valorVenda = valorVenda + aditivo.getValor();
		}
		
		return valorVenda;
	}
}