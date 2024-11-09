package br.edu.infnet.eder.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.eder.Constantes;
import br.edu.infnet.eder.model.domain.ELivro;
import br.edu.infnet.eder.model.service.ELivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/elivro")
public class ELivroController {
@Autowired
    private ELivroService eLivroService;
    
     @Operation(summary = "Recupera todos os livros eletrônicos existentes.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
    @GetMapping(value = "/lista")
	public ResponseEntity<Collection<ELivro>> obterLista(){
		
		return ResponseEntity.ok(eLivroService.obterLista());
	}

    @Operation(summary = "Incluir livro eletrônico.")
	@ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Criado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
    @PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@RequestBody ELivro livro) {
		eLivroService.incluir(livro);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MSG_INCLUSAO_SUCESSO);
	}
}
