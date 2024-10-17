package br.edu.infnet.eder.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.eder.model.domain.Autor;

@Service
public class AutorService {
	
	private Map<Integer, Autor> mapaAutores = new HashMap<Integer, Autor>();
	
	public void incluir(Autor autor) {
		mapaAutores.put(autor.getCodigo(), autor);
	}
	
	public Collection<Autor> obterLista(){
		return mapaAutores.values();
	}
}
