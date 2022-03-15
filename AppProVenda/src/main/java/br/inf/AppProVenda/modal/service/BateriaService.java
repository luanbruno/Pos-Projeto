package br.inf.AppProVenda.modal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.inf.AppProVenda.clients.IBateriaClient;
import br.inf.AppProVenda.modal.domain.Bateria;
import br.inf.AppProVenda.modal.domain.Usuario;

@Service
public class BateriaService {
	
	@Autowired
	private IBateriaClient bateriaClient;

	public Long obterQtde() {
		return bateriaClient.obterQtde();
	}

	public List<Bateria> obterLista(){

		return (List<Bateria>) bateriaClient.obterLista();
	}
	
	public List<Bateria> obterLista(Usuario usuario){
		return (List<Bateria>) bateriaClient.obterLista(usuario.getId());
	}

	public void incluir(Bateria bateria) {

		bateriaClient.incluir(bateria);
	}

	public Bateria obterPorId(Integer id) {

		return bateriaClient.obterPorId(id);
	}
}