package br.edu.infnet.apicliente.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.apicliente.model.domain.Cliente;
import br.edu.infnet.apicliente.model.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> obterLista() {		
		return (List<Cliente>) clienteRepository.findAll();
	}
	
	public List<Cliente> obterLista(Integer idUser){
		return clienteRepository.obterLista(idUser, Sort.by(Sort.Direction.ASC, "nome"));
	}	

	public void incluir(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public void excluir(Integer id) {
		clienteRepository.deleteById(id);
	}
	
	public Long obterQtde() {
		return clienteRepository.count();
	}
	
	public Cliente obterPorId(@PathVariable Integer id) {
		return clienteRepository.findById(id).orElse(null);
	}
}