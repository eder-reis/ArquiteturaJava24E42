package br.edu.infnet.eder.model.domain.dto;

public class EditoraRegiaoDto {
	private String nomeEditora;
	private String nomeRegiao;
	
	public EditoraRegiaoDto() {
		
	}
	
	public EditoraRegiaoDto(String nomeEditora, String nomeRegiao) {
		this.nomeEditora = nomeEditora;
		this.nomeRegiao = nomeRegiao;
	}
	
	public String getNomeEditora() {
		return nomeEditora;
	}
	
	public void setNomeEditora(String nomeEditora) {
		this.nomeEditora = nomeEditora;
	}
		
	public String getNomeRegiao() {
		return nomeRegiao;
	}

	public void setNomeRegiao(String nomeRegiao) {
		this.nomeRegiao = nomeRegiao;
	}
	
}
