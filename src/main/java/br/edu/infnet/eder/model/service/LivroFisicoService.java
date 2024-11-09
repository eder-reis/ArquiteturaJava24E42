package br.edu.infnet.eder.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.eder.exceptions.LivroNaoEncontradoException;
import br.edu.infnet.eder.model.domain.LivroFisico;
import br.edu.infnet.eder.model.repository.LivroFisicoRepository;

@Service
public class LivroFisicoService {

	@Autowired
	private LivroFisicoRepository livroFisicoRepository;
		
	public Collection<LivroFisico> obterLista(){
		return (Collection<LivroFisico>) livroFisicoRepository.findAll();
	}
	
	public void incluir(LivroFisico livro) {
		livroFisicoRepository.save(livro);
	}
	public long obterQtde() {
		return livroFisicoRepository.count();
	}

	public LivroFisico alterar(LivroFisico livro){
		boolean livroExiste = livroFisicoRepository.existsById(livro.getId());

		if (!livroExiste){
			throw new LivroNaoEncontradoException();
		}

		return livroFisicoRepository.save(livro);
	}
}
