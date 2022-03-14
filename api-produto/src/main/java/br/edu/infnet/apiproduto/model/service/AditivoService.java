package br.edu.infnet.apiproduto.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.apiproduto.model.domain.Aditivo;
import br.edu.infnet.apiproduto.model.repository.AditivoRepository;

@Service
public class AditivoService {
	
	@Autowired
	private AditivoRepository aditivoRepository;

	public List<Aditivo> obterLista() {		
		return (List<Aditivo>) aditivoRepository.findAll();
	}
	
	public List<Aditivo> obterLista(Integer idUser) {		
		return (List<Aditivo>) aditivoRepository.obterLista(idUser, Sort.by(Sort.Direction.ASC, "fabricante"));
	}

	public void incluir(Aditivo aditivo) {
		aditivoRepository.save(aditivo);
	}

	public Aditivo obterPorId(Integer id) {
		return aditivoRepository.findById(id).orElse(null);
	}

	public Long obterQtde() {
		return aditivoRepository.count();
	}
}