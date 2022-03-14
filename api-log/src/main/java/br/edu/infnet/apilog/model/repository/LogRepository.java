package br.edu.infnet.apilog.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.apilog.model.domain.Log;

@Repository
public interface LogRepository extends CrudRepository<Log, Integer> {

	public List<Log> findAll(Sort by);
}