package br.inf.AppProVenda.modal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.inf.AppProVenda.clients.IAditivoClient;
import br.inf.AppProVenda.modal.domain.Aditivo;
import br.inf.AppProVenda.modal.domain.Usuario;

@Service
public class AditivoService {
	
	@Autowired
	private IAditivoClient aditivoClient;

	
	public Long obterQtde() {
		return aditivoClient.obterQtde();
	}

	public List<Aditivo> obterLista(){

		return (List<Aditivo>) aditivoClient.obterLista();
	}
	
	public List<Aditivo> obterLista(Usuario usuario){
		return (List<Aditivo>) aditivoClient.obterLista(usuario.getId());
	}

	public void incluir(Aditivo aditivo) {

		aditivoClient.incluir(aditivo);
	}

	public Aditivo obterPorId(Integer id) {

		return aditivoClient.obterPorId(id);
	}
}