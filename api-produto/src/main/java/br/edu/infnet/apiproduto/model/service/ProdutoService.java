package br.edu.infnet.apiproduto.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.apiproduto.model.domain.Produto;
import br.edu.infnet.apiproduto.model.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> obterLista(){
		return (List<Produto>) produtoRepository.findAll();
	}

	public List<Produto> obterLista(Integer idUser){
		return produtoRepository.obterLista(idUser, Sort.by(Sort.Direction.ASC, "fabricante"));
	}

	public void excluir(Integer id) {
		produtoRepository.deleteById(id);
	}
	
	public Produto obterPorId(Integer id) {
		return produtoRepository.findById(id).orElse(null);
	}

	public Long obterQtde() {
		return produtoRepository.count();
	}
	
	public void incluir(Produto produto) {
		produtoRepository.save(produto);
	}
}