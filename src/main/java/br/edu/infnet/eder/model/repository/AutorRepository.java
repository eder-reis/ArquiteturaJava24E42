package br.edu.infnet.eder.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.eder.model.domain.Autor;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Integer> {

}
