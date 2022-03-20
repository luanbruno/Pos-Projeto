package br.edu.infnet.dashboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.clients.IProdutoClient;
import br.edu.infnet.dashboard.model.domain.Lubrificante;

@Service
public class LubrificanteService {
	
	@Autowired
	private IProdutoClient produtoClient;
	
	public List<Lubrificante> obterLista() {
		return produtoClient.obterLubrificanteLista();
	}
	
	public float calcularValorVenda() {
		
		float valorVenda = 0;
		
		for(Lubrificante lubrificante : produtoClient.obterLubrificanteLista()) {
			valorVenda = valorVenda + lubrificante.getValor();
		}
		
		return valorVenda;
	}
}