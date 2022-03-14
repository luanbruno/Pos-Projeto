package br.edu.infnet.apiproduto.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apiproduto.model.domain.Aditivo;

@Repository
public interface AditivoRepository extends CrudRepository<Aditivo, Integer> {

	@Query("from Aditivo b where b.usuario.id = :userid")
	List<Aditivo> obterLista(Integer userid, Sort by);
}