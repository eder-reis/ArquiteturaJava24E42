package br.edu.infnet.eder.model.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.infnet.eder.model.domain.LivroFisico;

public interface LivroFisicoRepository extends  CrudRepository<LivroFisico, Integer>{
    
}
