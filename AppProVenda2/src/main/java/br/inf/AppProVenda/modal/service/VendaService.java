package br.inf.AppProVenda.modal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.inf.AppProVenda.modal.domain.Usuario;
import br.inf.AppProVenda.modal.domain.Venda;

@Service
public class VendaService {
	
	
	public List<Venda> obterLista() {
		return null;
	}
		
	public List<Venda> obterLista(Usuario usuario) {
		return null;

	}

	public Venda obterPorId(Integer id) {
		return null;

	}
	
	public void incluir(Venda venda) {
	}
	
	public void excluir(Integer id) {
	}
	
	public Long obterQtd() {
		return null;
	}
}