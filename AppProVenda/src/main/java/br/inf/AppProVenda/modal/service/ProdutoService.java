package br.inf.AppProVenda.modal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.inf.AppProVenda.clients.IProdutoClient;
import br.inf.AppProVenda.modal.domain.Produto;
import br.inf.AppProVenda.modal.domain.Usuario;

@Service
public class ProdutoService {
	
	@Autowired
	private IProdutoClient produtoClient;

	public Long obterQtde() {
		return produtoClient.obterQtde();
	}
	
	public List<Produto> obterLista(){
		return (List<Produto>) produtoClient.obterLista();
	}

	public List<Produto> obterLista(Usuario usuario){
		return (List<Produto>) produtoClient.obterLista(usuario.getId());
	}

	public void excluir(Integer id) {

		produtoClient.excluir(id);
	}
	
	public Produto obterPorId(Integer id) {

		return produtoClient.obterPorId(id);
	}
}