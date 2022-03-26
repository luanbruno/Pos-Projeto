package br.inf.AppProVenda.modal.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.inf.AppProVenda.modal.domain.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

	@Query("from Produto p where p.usuario.id = :userid")
	List<Produto> findAll(Integer userid, Sort sort);

}