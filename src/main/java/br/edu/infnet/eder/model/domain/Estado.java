package br.edu.infnet.eder.model.domain;

public class Estado extends Regiao {
	private Regiao regiao;
	
	public Regiao getRegiao() {
		return regiao;
	}
	
	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
}