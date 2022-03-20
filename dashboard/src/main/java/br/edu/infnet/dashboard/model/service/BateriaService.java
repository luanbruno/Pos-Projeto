package br.edu.infnet.dashboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.apiproduto.model.domain.Bateria;
import br.edu.infnet.apiproduto.model.repository.BateriaRepository;

@Service
public class BateriaService {
	
	@Autowired
	private BateriaRepository bateriaRepository;

	public List<Bateria> obterLista() {		
		return (List<Bateria>) bateriaRepository.findAll();
	}
	
	public List<Bateria> obterLista(Integer idUser) {		
		return (List<Bateria>) bateriaRepository.obterLista(idUser, Sort.by(Sort.Direction.ASC, "fabricante"));
	}

	public void incluir(Bateria bateria) {
		bateriaRepository.save(bateria);
	}

	public Bateria obterPorId(Integer id) {
		return bateriaRepository.findById(id).orElse(null);
	}

	public Long obterQtde() {
		return bateriaRepository.count();
	}
}