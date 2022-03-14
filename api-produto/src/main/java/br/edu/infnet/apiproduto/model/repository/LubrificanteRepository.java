package br.edu.infnet.apiproduto.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apiproduto.model.domain.Lubrificante;

@Repository
public interface LubrificanteRepository extends CrudRepository<Lubrificante, Integer> {

	@Query("from Lubrificante b where b.usuario.id = :userid")
	List<Lubrificante> obterLista(Integer userid, Sort by);
}