package br.edu.infnet.apiproduto.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.apiproduto.model.domain.Lubrificante;
import br.edu.infnet.apiproduto.model.repository.LubrificanteRepository;

@Service
public class LubrificanteService {
	
	@Autowired
	private LubrificanteRepository lubrificanteRepository;

	public List<Lubrificante> obterLista() {		
		return (List<Lubrificante>) lubrificanteRepository.findAll();
	}
	
	public List<Lubrificante> obterLista(Integer idUser) {		
		return (List<Lubrificante>) lubrificanteRepository.obterLista(idUser, Sort.by(Sort.Direction.ASC, "fabricante"));
	}

	public void incluir(Lubrificante lubrificante) {
		lubrificanteRepository.save(lubrificante);
	}

	public Lubrificante obterPorId(Integer id) {
		return lubrificanteRepository.findById(id).orElse(null);
	}

	public Long obterQtde() {
		return lubrificanteRepository.count();
	}
}