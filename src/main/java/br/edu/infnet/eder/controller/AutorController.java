package br.edu.infnet.eder.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.eder.model.domain.Autor;
import br.edu.infnet.eder.model.service.AutorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/autor")
public class AutorController {
	private static final String MSG_INCLUSAO_SUCESSO = "Inclusão realizada com sucesso.";
	private static final String MSG_EXCLUSAO_SUCESSO = "Exclusão realizada com sucesso.";
	private static final String MSG_EXCLUSAO_NOT_FOUND = "Autor não encontrado.";

	@Autowired
	private AutorService autorService;
	
	@Operation(summary = "Recupera todos os autores existentes.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@GetMapping(value = "/obterLista")
	public ResponseEntity<Collection<Autor>> obterAutores(){
		return ResponseEntity.ok(autorService.obterLista());
	}

	@Operation(summary = "Recupera todos os autores existentes com o nome ou parte do nome.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "404", description = "Não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@GetMapping(value = "/buscarPorNome")
	public ResponseEntity<Collection<Autor>> buscarPorNome(@RequestParam String nome){
		Collection<Autor> autores = autorService.buscarPorNome(nome);

		if (autores.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(autores);
		}

		return ResponseEntity.ok(autores);
	}

	@Operation(summary = "Recupera autor existente pelo Id.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@GetMapping
	public ResponseEntity<Autor> obterPorId(@RequestParam Integer id) {
		return ResponseEntity.ok(autorService.obterPorId(id));
	}

	@Operation(summary = "Incluir autor.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Criado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@RequestBody Autor autor) {
		autorService.incluir(autor);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(MSG_INCLUSAO_SUCESSO);
	}

	@Operation(summary = "Exclui autor pelo Id.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "404", description = "Não encontrado"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@DeleteMapping(value = "/excluir")
	public ResponseEntity<String> excluir(@RequestParam Integer id) {
		if(autorService.excluir(id)) {
			return ResponseEntity.ok(MSG_EXCLUSAO_SUCESSO);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MSG_EXCLUSAO_NOT_FOUND);
	}
}
