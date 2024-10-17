package br.edu.infnet.eder.model.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Livro {
	private int codigo;
	private String nome;
	private Editora editora;
	private float preco;
	private List<Comentario> comentarios;
	
	public Livro() {
		comentarios = new ArrayList<Comentario>();
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigo() {
		return codigo;
	}
	
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public float getPreco() {
		return preco;
	}
}
