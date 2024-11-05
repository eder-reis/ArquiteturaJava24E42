package br.edu.infnet.eder.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.eder.model.domain.Livro;

public interface LivroRepository extends CrudRepository<Livro, Integer> {
    List<Livro> findByPrecoBetween(float precoInicial, float precoFinal);
}
