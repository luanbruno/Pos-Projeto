package br.inf.AppProVenda.modal.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.inf.AppProVenda.modal.domain.Lubrificante;

@Repository
public interface LubrificanteRepository extends CrudRepository<Lubrificante, Integer> {

	@Query("from Lubrificante l where l.usuario.id = :userid")
	List<Lubrificante> findAll(Integer userid, Sort sort);
	
	List<Lubrificante> findAll(Sort by);
}