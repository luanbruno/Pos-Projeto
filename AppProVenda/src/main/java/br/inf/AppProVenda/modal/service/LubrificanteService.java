package br.inf.AppProVenda.modal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.inf.AppProVenda.clients.ILubrificanteClient;
import br.inf.AppProVenda.modal.domain.Lubrificante;
import br.inf.AppProVenda.modal.domain.Usuario;

@Service
public class LubrificanteService {
	
	@Autowired
	private ILubrificanteClient lubrificanteClient;


	public Long obterQtde() {
		return lubrificanteClient.obterQtde();
	}

	public List<Lubrificante> obterLista(){

		return (List<Lubrificante>) lubrificanteClient.obterLista();
	}
	
	public List<Lubrificante> obterLista(Usuario usuario){
		return (List<Lubrificante>) lubrificanteClient.obterLista(usuario.getId());
	}

	public void incluir(Lubrificante lubrificante) {

		lubrificanteClient.incluir(lubrificante);

	}

	public Lubrificante obterPorId(Integer id) {

		return lubrificanteClient.obterPorId(id);
		
	}
}