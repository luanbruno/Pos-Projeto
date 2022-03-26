package br.inf.AppProVenda.modal.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.inf.AppProVenda.modal.domain.Venda;

@Repository
public interface VendaRepository extends CrudRepository<Venda, Integer> {

	@Query("from Venda v where v.usuario.id = :userid")
	List<Venda> findAll(Integer userid, Sort sort);
	
	List<Venda> findAll(Sort by);
}