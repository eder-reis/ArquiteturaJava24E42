package br.edu.infnet.eder.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.eder.Constantes;
import br.edu.infnet.eder.model.domain.Livro;
import br.edu.infnet.eder.model.service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/livro")
public class LivroController {
    @Autowired
	private LivroService livroService;
    
    @Operation(summary = "Recupera todos os livros existentes por faixa de preço.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "404", description = "Não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
    @GetMapping(value = "/obterListaPorPreco")
    public ResponseEntity<List<Livro>> obterListaPorPreco(@RequestParam float precoInicial, @RequestParam float precoFinal){
        if(precoInicial < 0 || precoFinal < 0 || precoInicial > precoFinal) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
        
        List<Livro> livros = livroService.obterListaPorPreco(precoInicial, precoFinal);

        if (livros.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(livros);
        }
        
        return ResponseEntity.ok(livros);
    }

    @Operation(summary = "Recupera todos os livros existentes.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
    @GetMapping(value = "/obterLista")
	public ResponseEntity<Collection<Livro>> obterLista(){
		
		return ResponseEntity.ok(livroService.obterLista());
	}
	
    @Operation(summary = "Excluir livro.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
    @DeleteMapping(value = "/excluir")
	public ResponseEntity<String> excluir(@RequestParam Integer id) {
		
		livroService.excluir(id);
		
		return ResponseEntity.ok(Constantes.MSG_EXCLUSAO_SUCESSO);
	}

    @Operation(summary = "Recupera livro por id.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
    @GetMapping()
	public ResponseEntity<Livro> obterPorId(@RequestParam Integer id) {
		return ResponseEntity.ok(livroService.obterPorId(id));
	}


	@PatchMapping(value = "/alterarPreco")
	public ResponseEntity<Livro> alterar(@RequestParam Integer id, @RequestParam float preco) {
		Livro livroAtualizado = livroService.alterarPreco(id, preco);
		
		return ResponseEntity.ok(livroAtualizado);
	}
}