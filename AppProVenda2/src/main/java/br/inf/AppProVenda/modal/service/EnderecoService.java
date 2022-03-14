package br.inf.AppProVenda.modal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.inf.AppProVenda.clients.IEnderecoClient;
import br.inf.AppProVenda.modal.domain.Endereco;

@Service
public class EnderecoService {
	
	@Autowired
	private IEnderecoClient enderecoClient;
	
	public Endereco obterPorCep(String cep) {
	
		return enderecoClient.buscarCep(cep);
	}

}