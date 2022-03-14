package br.edu.infnet.dashboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.clients.ISolicitanteClient;
import br.edu.infnet.dashboard.model.domain.Solicitante;

@Service
public class SolicitanteService {

	@Autowired
	public ISolicitanteClient solicitanteClient; 
	
	public List<Solicitante> obterLista(){
		return solicitanteClient.obterLista();
	}
}