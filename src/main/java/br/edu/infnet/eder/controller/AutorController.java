package br.edu.infnet.eder.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.eder.model.domain.Autor;
import br.edu.infnet.eder.model.domain.dto.AutorDto;
import br.edu.infnet.eder.model.service.AutorService;

@RestController
public class AutorController {
	

	@Autowired
	private AutorService autorService;
	
	@GetMapping(value = "autor/obterLista")
	public Collection<Autor> obterAutores(){
		return autorService.obterLista();
	}

	@GetMapping(value = "autor/buscarPorNome")
	public Collection<Autor> buscarPorNome(@RequestParam String nome){
		return autorService.buscarPorNome(nome);
	}

	@GetMapping(value = "autor")
	public Autor obterPorId(@RequestParam Integer id) {
		return autorService.obterPorId(id);
	}

	@PostMapping(value = "autor/incluir")
	public Autor incluir(@RequestBody AutorDto autorDto) {
		
		Autor autor = autorService.incluir(autorDto);
		
		return autor;
	}
	
	@DeleteMapping(value = "autor/excluir")
	public String excluir(@RequestParam Integer id) {
		
		autorService.excluir(id);
		
		return "Exclusão realizada com sucesso.";
	}
}
