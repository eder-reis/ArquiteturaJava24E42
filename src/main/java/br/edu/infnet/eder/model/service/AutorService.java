package br.edu.infnet.eder.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.eder.model.domain.Autor;
import br.edu.infnet.eder.model.repository.AutorRepository;

@Service
public class AutorService {
	@Autowired
	private AutorRepository autorRepository;
	
	public Autor incluir(Autor autor) {
		return autorRepository.save(autor);
	}
	
	public boolean excluir(Integer id){
		autorRepository.deleteById(id);
		return true;
	}

	public Collection<Autor> obterLista(){
		return (Collection<Autor>)autorRepository.findAll(Sort.by(Sort.Order.asc("nome")));
	}

	public Collection<Autor> buscarPorNome(String nome){
		return (Collection<Autor>)autorRepository.findByNomeContaining(nome, Sort.by(Sort.Order.asc("nome")));
	}

	public Autor obterPorId(Integer id){
		return autorRepository.findById(id).orElse(null);
	}
}
