package br.edu.infnet.eder.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.eder.model.domain.Livro;
import br.edu.infnet.eder.model.repository.LivroRepository;

@Service
public class LivroService {
	/*@Autowired
	private AutorService autorService;*/
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void incluir(Livro livro) {
		livroRepository.save(livro);
	}
}
