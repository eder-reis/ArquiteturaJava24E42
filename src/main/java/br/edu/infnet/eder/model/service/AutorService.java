package br.edu.infnet.eder.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.eder.model.domain.Autor;
import br.edu.infnet.eder.model.domain.dto.AutorDto;
import br.edu.infnet.eder.model.repository.AutorRepository;

@Service
public class AutorService {
	@Autowired
	private AutorRepository autorRepository;
	
	public Autor incluir(Autor autor) {
		return autorRepository.save(autor);
	}
	
	public Autor incluir(AutorDto autorDto){
		Autor autor = new Autor(autorDto.getNome(), autorDto.getDataNascimento());

		return incluir(autor);
	}

	public void excluir(Integer id){
		autorRepository.deleteById(id);
	}

	public Collection<Autor> obterLista(){
		return (Collection<Autor>)autorRepository.findAll();
	}

	public Collection<Autor> buscarPorNome(String nome){
		return (Collection<Autor>)autorRepository.findByNomeContaining(nome);
	}

	public Autor obterPorId(Integer id){
		return autorRepository.findById(id).orElse(null);
	}
}
