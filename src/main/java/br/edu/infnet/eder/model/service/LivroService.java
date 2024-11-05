package br.edu.infnet.eder.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.eder.model.domain.Livro;
import br.edu.infnet.eder.model.repository.EditoraRepository;
import br.edu.infnet.eder.model.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private EditoraRepository editoraRepository;

	@Autowired
	private LivroRepository livroRepository;
	
	public void incluir(Livro livro) {
		
		if (livro.getEditora().getId() == null){
			editoraRepository.save(livro.getEditora());
		}

		livroRepository.save(livro);
	}
	
	public List<Livro> obterListaPorPreco(float precoInicial, float precoFinal){
		return livroRepository.findByPrecoBetween(precoInicial, precoFinal);
	}
}
