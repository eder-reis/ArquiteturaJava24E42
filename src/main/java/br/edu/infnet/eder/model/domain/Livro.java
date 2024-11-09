package br.edu.infnet.eder.model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Livro")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "O nome do livro é obrigatório.")
	@Size(min = 3, max = 50, message = "O nome do livro deve conter entre 3 a 50 caracteres.")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="idEditora")
	@JsonManagedReference
	private Editora editora;
		
	@ManyToOne
	@JoinColumn(name = "idAutor")
	@JsonBackReference
	private Autor autor;
	
	@DecimalMin(value = "0.01", message = "O preço deve ser maior que zero.")
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
