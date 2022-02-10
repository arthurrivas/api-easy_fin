package br.com.easyfinapi.dtos;

public class QuestaoDTO {
	
	private String descricaoQuestao;
	
	private String alternativaCerta;
	
	
	public QuestaoDTO() {
	}
	

	public QuestaoDTO(String descricaoQuestao, String alternativaCerta) {
		this.descricaoQuestao = descricaoQuestao;
		this.alternativaCerta = alternativaCerta;
	}


	public String getDescricaoQuestao() {
		return descricaoQuestao;
	}


	public void setDescricaoQuestao(String descricaoQuestao) {
		this.descricaoQuestao = descricaoQuestao;
	}


	public String getAlternativaCerta() {
		return alternativaCerta;
	}


	public void setAlternativaCerta(String alternativaCerta) {
		this.alternativaCerta = alternativaCerta;
	}
	
	
	
	
}
