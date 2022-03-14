package br.edu.infnet.dashboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.clients.IProdutoClient;
import br.edu.infnet.dashboard.model.domain.Produto;

@Service
public class ProdutoService {
	
	@Autowired
	private IProdutoClient produtoClient;
	
	public List<Produto> obterLista() {
		return produtoClient.obterLista();
	}
}