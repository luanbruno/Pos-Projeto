package br.edu.infnet.apicliente.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apicliente.model.domain.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {


	@Query("from Cliente s where s.usuario.id = :userid")
	List<Cliente> obterLista(Integer userid, Sort by);	
}