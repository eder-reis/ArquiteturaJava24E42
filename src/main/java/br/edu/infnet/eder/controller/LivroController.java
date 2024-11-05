package br.edu.infnet.eder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.eder.model.domain.Livro;
import br.edu.infnet.eder.model.service.LivroService;

@RestController
public class LivroController {
    @Autowired
	private LivroService livroService;
    
    @GetMapping(value = "livro/obterListaPorPreco")
    public List<Livro> obterListaPorPreco(@RequestParam float precoInicial, @RequestParam float precoFinal){
        return livroService.obterListaPorPreco(precoInicial, precoFinal);
    }
}
