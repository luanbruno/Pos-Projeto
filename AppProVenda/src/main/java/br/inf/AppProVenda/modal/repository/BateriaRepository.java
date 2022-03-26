package br.inf.AppProVenda.modal.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.inf.AppProVenda.modal.domain.Bateria;

@Repository
public interface BateriaRepository extends CrudRepository<Bateria, Integer> {

	@Query("from Bateria b where b.usuario.id = :userid")
	List<Bateria> findAll(Integer userid, Sort sort);
	
	List<Bateria> findAll(Sort by);
}