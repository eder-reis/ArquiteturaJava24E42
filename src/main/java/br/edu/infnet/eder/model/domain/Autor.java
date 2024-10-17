package br.edu.infnet.eder.model.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Autor {
	private int codigo;
	private String nome;
	private LocalDate dataNascimento; 
	private List<Livro> livros;
	
	public Autor() {
		livros = new ArrayList<Livro>();
	}
	
	@Override
	public String toString() {
		return String.format("[%d] Autor: %s cadastrado com sucesso! Quantidade de livros: %d",
				codigo, nome, livros.size());
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
}
