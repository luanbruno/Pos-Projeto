package br.edu.infnet.dashboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.apipedido.model.domain.Venda;
import br.edu.infnet.apipedido.model.repository.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository vendaRepository;

	public List<Venda> obterLista() {		
		return (List<Venda>) vendaRepository.findAll(Sort.by(Sort.Direction.ASC, "data"));
	}
	
	public List<Venda> obterLista(Integer idUser){
		return vendaRepository.findAll(idUser, Sort.by(Sort.Direction.ASC, "tipo"));
	}	

	public void incluir(Venda venda) {
		vendaRepository.save(venda);
	}
	
	public void excluir(Integer id) {
		vendaRepository.deleteById(id);
	}
	
	public Long obterQtde() {
		return vendaRepository.count();
	}
	
	public Venda obterPorId(@PathVariable Integer id) {
		return vendaRepository.findById(id).orElse(null);
	}
}