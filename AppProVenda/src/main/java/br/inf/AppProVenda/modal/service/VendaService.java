package br.inf.AppProVenda.modal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.inf.AppProVenda.clients.IVendaClient;
import br.inf.AppProVenda.modal.domain.Usuario;
import br.inf.AppProVenda.modal.domain.Venda;

@Service
public class VendaService {
	
	
	@Autowired
	private IVendaClient vendaClient;

	public Long obterQtde() {
		return vendaClient.obterQtde();
	}

	public List<Venda> obterLista(){
		return vendaClient.obterLista();
	}
	
	public List<Venda> obterLista(Usuario usuario){
		return vendaClient.obterLista(usuario.getId());
	}

	public void incluir(Venda venda) {
		vendaClient.incluir(venda);	
		
	}
	
	public void excluir(Integer id) {
		vendaClient.excluir(id);
	}
	
	public Venda obterPorId(Integer id) {
		return vendaClient.obterPorId(id);
	}
}