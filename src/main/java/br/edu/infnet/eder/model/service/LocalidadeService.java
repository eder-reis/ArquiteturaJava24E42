package br.edu.infnet.eder.model.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.eder.client.LocalidadeClient;
import br.edu.infnet.eder.model.domain.Autor;
import br.edu.infnet.eder.model.domain.Endereco;
import br.edu.infnet.eder.model.domain.Estado;
import br.edu.infnet.eder.model.domain.Livro;
import br.edu.infnet.eder.model.domain.Municipio;
import br.edu.infnet.eder.model.domain.dto.EditoraRegiaoDto;

@Service
public class LocalidadeService {
	@Autowired
	private AutorService autorService;
	
	@Autowired
	private LocalidadeClient localidadeClient;
	
	public Collection<Estado> obterEstados(){
		return localidadeClient.obterEstados();
	}
	
	public Collection<Municipio> obterMunicipios(Integer id){
		return localidadeClient.obterMunicipios(id);
	}
	
	public Collection<EditoraRegiaoDto> obterEditorasRegiao() {
		Collection<Autor> autores = autorService.obterLista();
		
		Collection<Estado> estados = localidadeClient.obterEstados();
		
		Collection<EditoraRegiaoDto> editorasRegioes = new ArrayList<EditoraRegiaoDto>();
		
		for(Autor autor: autores) {
			for(Livro livro: autor.getLivros())	{
				Endereco endereco = livro.getEditora().getEndereco();
				
				String uf = endereco.getUf();
				
				for(Estado estado: estados) {
					String sigla = estado.getSigla();
										
					if (sigla.equals(uf)) {
						EditoraRegiaoDto editoraRegiao = new EditoraRegiaoDto(livro.getEditora().getNome(), estado.getRegiao().getNome());
						
						boolean objetoNovo = true;
						
						for(EditoraRegiaoDto dto: editorasRegioes) {
							if (dto.getNomeEditora().equals(livro.getEditora().getNome()) && dto.getNomeRegiao().equals(estado.getRegiao().getNome())) {
								objetoNovo = false;
							}
						}
						
						if (objetoNovo) {
							editorasRegioes.add(editoraRegiao);
						}
					}
				}
			}
		}
				
		return editorasRegioes;
	}
}
