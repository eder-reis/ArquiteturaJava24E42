package br.edu.infnet.eder.model.domain;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ELivro")
public class ELivro extends Livro {
	private String link;
	private int numeroDownloads;
	
	public int getNumeroDownloads() {
		return numeroDownloads;
	}

	public void setNumeroDownloads(int numeroDownloads) {
		this.numeroDownloads = numeroDownloads;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
