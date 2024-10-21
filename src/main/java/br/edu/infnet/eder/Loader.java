package br.edu.infnet.eder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.eder.client.EnderecoClient;
import br.edu.infnet.eder.client.LocalidadeClient;
import br.edu.infnet.eder.model.domain.Autor;
import br.edu.infnet.eder.model.domain.Comentario;
import br.edu.infnet.eder.model.domain.ELivro;
import br.edu.infnet.eder.model.domain.Editora;
import br.edu.infnet.eder.model.domain.Endereco;
import br.edu.infnet.eder.model.domain.Estado;
import br.edu.infnet.eder.model.domain.Livro;
import br.edu.infnet.eder.model.domain.LivroFisico;
import br.edu.infnet.eder.model.domain.Municipio;
import br.edu.infnet.eder.model.service.AutorService;

@Component
public class Loader implements ApplicationRunner {

	@Autowired
	private AutorService autorService;
	
	@Autowired
	private EnderecoClient enderecoClient;
	
	@Autowired
	private LocalidadeClient localidadeClient;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		for(Estado estado : localidadeClient.obterEstados()) {
			System.out.println("ESTADO: " + estado.getNome());
		}
		
		for(Municipio municipio : localidadeClient.obterMunicipios(33)) {
			System.out.println("MUNICÍPIO: " + municipio.getNome());
		}
		
		// TODO Auto-generated method stub
		FileReader file = new FileReader("arquivos/base.txt");
		
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();
		
		Autor autor = null;
		Editora editora = null;
		
		while(linha != null) {
			
			String[] campos = linha.split(";");
			
			switch(campos[0].toUpperCase()) {
				case "A":
					autor = new Autor();
					
					autor.setCodigo(Integer.parseInt(campos[1]));
					
					autor.setNome(campos[2]);
					
					autor.setDataNascimento(LocalDate.parse(campos[3]));
					
					autorService.incluir(autor);
					break;
					
				case "E":
					
					editora = new Editora();
					
					editora.setCodigo(Integer.parseInt(campos[1]));
					
					editora.setNome(campos[3]);
					
					editora.setEnderecoWeb(campos[4]);
					
					break;
				case "LF":
					LivroFisico livro = new LivroFisico();
					
					livro.setCodigo(Integer.parseInt(campos[1]));
					
					livro.setNome(campos[3]);
					
					livro.setEditora(editora);
					
					livro.setPreco(Float.parseFloat(campos[4]));
					
					livro.setTemEstoque(Boolean.parseBoolean(campos[5]));
					
					livro.setCapaDura(Boolean.parseBoolean(campos[6]));
					
					livro.setEditora(editora);
					
					autor.getLivros().add(livro);
					
					break;
						
				case "LE":
					ELivro eLivro = new ELivro();
					
					eLivro.setCodigo(Integer.parseInt(campos[1]));
					
					eLivro.setNome(campos[3]);
					
					eLivro.setEditora(editora);
					
					eLivro.setPreco(Float.parseFloat(campos[4]));
					
					eLivro.setLink(campos[5]);
					
					eLivro.setNumeroDownloads(Integer.parseInt(campos[6]));
					
					eLivro.setEditora(editora);
					
					autor.getLivros().add(eLivro);
					break;
					
				case "C":
					Comentario comentario = new Comentario();
					
					comentario.setCodigo(Integer.parseInt(campos[1]));
					
					comentario.setAtivo(Boolean.parseBoolean(campos[3]));
					
					comentario.setResenha(campos[4]);
					
					autor.getLivros().get(Integer.parseInt(campos[2])).getComentarios().add(comentario);
					
					break;
					
				case "END":
					
					Endereco endereco = enderecoClient.findByCep(campos[1]);
					
					endereco.setCep(campos[1]);
					
					for(Livro livroDoAutor: autor.getLivros()) {
						livroDoAutor.getEditora().setEndereco(endereco);
					}
					
				default:
					break;
			}
			
			linha = leitura.readLine();
						
		}
		
		for(Autor a:autorService.obterLista()) {
			System.out.println("Autor cadastrado com sucesso: " + a);
		}
		
		leitura.close();
	}
}
