package br.edu.infnet.apipedido.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.apipedido.model.domain.Venda;
import br.edu.infnet.apipedido.model.repository.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository vendaRepository;

	public List<Venda> obterLista() {		
		return (List<Venda>) vendaRepository.findAll(Sort.by(Sort.Direction.ASC, "data"));
	}
	
	public long obterQuantidade() {
		return vendaRepository.count();
	}
}