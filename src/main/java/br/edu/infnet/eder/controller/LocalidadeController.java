package br.edu.infnet.eder.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.eder.model.domain.Estado;
import br.edu.infnet.eder.model.domain.Municipio;
import br.edu.infnet.eder.model.domain.dto.EditoraRegiaoDto;
import br.edu.infnet.eder.model.service.LocalidadeService;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {
	
	@Autowired
	private LocalidadeService localidadeService;
	
	@GetMapping("/obterListaEstados")
	public Collection<Estado> obterEstados(){
		return localidadeService.obterEstados();
	}
	
	@GetMapping("/obterListaMunicipios")
	public Collection<Municipio> obterMunicipios(@RequestParam Integer id){
		return localidadeService.obterMunicipios(id);
	}
	
	@GetMapping("/obterEditorasRegiao")
	public Collection<EditoraRegiaoDto> obterEditorasRegiao(){
		return localidadeService.obterEditorasRegiao();
	}
}
