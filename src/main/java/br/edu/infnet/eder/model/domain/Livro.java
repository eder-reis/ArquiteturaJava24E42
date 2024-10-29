package br.edu.infnet.eder.model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Livro")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	
	@Transient
	private Editora editora;
		
	@ManyToOne
	@JoinColumn(name = "idAutor")
	private Autor autor;
	
	private float preco;
	// @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
	// @JoinColumn(name = "idAutor")
	@Transient
	private List<Comentario> comentarios;
	
	public Livro() {
		comentarios = new ArrayList<Comentario>();
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public Autor getAutor() {
		return autor;
	}
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
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
