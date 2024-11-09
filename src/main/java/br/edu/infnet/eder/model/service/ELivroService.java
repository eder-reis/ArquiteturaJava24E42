package br.edu.infnet.eder.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.eder.model.domain.ELivro;
import br.edu.infnet.eder.model.repository.ELivroRepository;

@Service
public class ELivroService {
    @Autowired
    private ELivroRepository eLivroRepository;	
	public Collection<ELivro> obterLista(){
		return (Collection<ELivro>) eLivroRepository.findAll();
	}
	
	public void incluir(ELivro livro) {
		eLivroRepository.save(livro);
	}
	public long obterQtde() {
		return eLivroRepository.count();
	}
}
