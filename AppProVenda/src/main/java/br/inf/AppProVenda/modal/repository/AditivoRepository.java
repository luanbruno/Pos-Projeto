package br.inf.AppProVenda.modal.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.inf.AppProVenda.modal.domain.Aditivo;

@Repository
public interface AditivoRepository extends CrudRepository<Aditivo, Integer> {

	@Query("from Aditivo a where a.usuario.id = :userid")
	List<Aditivo> findAll(Integer userid, Sort sort);
	
	List<Aditivo> findAll(Sort by);
}