package br.edu.infnet.apipedido.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apipedido.model.domain.Venda;

@Repository
public interface VendaRepository extends CrudRepository<Venda, Integer> {

	@Query("from Venda p where p.usuario.id = :userid")
	List<Venda> findAll(Integer userid, Sort by);

	List<Venda> findAll(Sort by);
}