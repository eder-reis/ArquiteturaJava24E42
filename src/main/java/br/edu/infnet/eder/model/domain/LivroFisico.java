package br.edu.infnet.eder.model.domain;

public class LivroFisico extends Livro {
	private boolean temEstoque;
	private boolean capaDura;
	
	public boolean isCapaDura() {
		return capaDura;
	}

	public void setCapaDura(boolean capaDura) {
		this.capaDura = capaDura;
	}

	public boolean isTemEstoque() {
		return temEstoque;
	}

	public void setTemEstoque(boolean temEstoque) {
		this.temEstoque = temEstoque;
	}
}
