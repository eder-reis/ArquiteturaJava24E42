package br.edu.infnet.eder.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.eder.model.domain.Autor;
import br.edu.infnet.eder.model.repository.AutorRepository;

@Service
public class AutorService {
	
	private Map<Integer, Autor> mapaAutores = new HashMap<Integer, Autor>();

	@Autowired
	private AutorRepository autorRepository;
	
	public void incluir(Autor autor) {
		mapaAutores.put(autor.getCodigo(), autor);
		autorRepository.save(autor);
	}
	
	public Collection<Autor> obterLista(){
		return mapaAutores.values();
	}
}
