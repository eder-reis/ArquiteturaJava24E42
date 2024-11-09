package br.edu.infnet.eder.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.eder.model.service.LivroFisicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.eder.model.domain.LivroFisico;

@RestController
@RequestMapping("/livrofisico")
public class LivroFisicoController {
    @Autowired
    private LivroFisicoService livroFisicoService;

    @Operation(summary = "Recupera todos os livros físicos existentes.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
        @GetMapping(value = "/lista")
	public ResponseEntity<Collection<LivroFisico>> obterLista(){
		
		return ResponseEntity.ok(livroFisicoService.obterLista());
	}

    @Operation(summary = "Incluir livro físico.")
	@ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Criado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
    @PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@RequestBody LivroFisico livro) {
		livroFisicoService.incluir(livro);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Inclusão realizada com sucesso.");
	}
}