package br.inf.AppProVenda.modal.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.inf.AppProVenda.modal.domain.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

	@Query("from Cliente c where c.usuario.id = :userid")
	public List<Cliente> findAll(Integer userid, Sort sort);
}