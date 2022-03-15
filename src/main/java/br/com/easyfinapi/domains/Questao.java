package br.com.easyfinapi.domains;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Questao {

	@Id
	private String id;
	private String descricaoQuestao;
	
	
	private List<Alternativa> alternativas = new ArrayList<>();
	
	
	public Questao() {
	}

	

	public Questao(String id, String descricaoQuestao) {
		this.id = id;
		this.descricaoQuestao = descricaoQuestao;
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

	public void setAlternativasErrada(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}
	
	public void addAlternativa(Alternativa alternativa) {
		this.alternativas.add(alternativa);
	}
	
	
	
	
}
