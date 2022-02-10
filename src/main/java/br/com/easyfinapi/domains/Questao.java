package br.com.easyfinapi.domains;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Questao {

	@Id
	private String id;
	private String descricaoQuestao;
	
	private String alternativaCerta;
	private List<String> alternativasErrada;
	
	
	public Questao() {
	}

	

	public Questao(String id, String descricaoQuestao, String alternativaCerta) {
		this.id = id;
		this.descricaoQuestao = descricaoQuestao;
		this.alternativaCerta = alternativaCerta;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<String> getAlternativasErrada() {
		return alternativasErrada;
	}

	public void setAlternativasErrada(List<String> alternativasErrada) {
		this.alternativasErrada = alternativasErrada;
	}
	
	
	
	
}
