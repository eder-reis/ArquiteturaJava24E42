package br.edu.infnet.eder.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.eder.model.domain.Autor;
import br.edu.infnet.eder.model.service.AutorService;

@RestController
public class AutorController {
	

	@Autowired
	private AutorService autorService;
	
	@GetMapping(value = "autor/obterLista")
	public Collection<Autor> obterAutores(){
		return autorService.obterLista();
	}
}
