package br.inf.AppProVenda.modal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.inf.AppProVenda.modal.domain.Cliente;
import br.inf.AppProVenda.modal.domain.Usuario;

@Service
public class ClienteService {
	

	public List<Cliente> obterLista(){
		return null;	
	}
	
	public List<Cliente> obterLista(Usuario usuario){
		return null;
	}

	public void incluir(Cliente cliente) {
	}
	
	public void excluir(Integer id) {
	}
	
	public Cliente obterPorId(Integer id) {
		return null;
	}
	
	public Long obterQtd() {
		return null;
	}
}