package br.com.easyfinapi.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Questao {

	@Id
	private String id;
	private String descricaoQuestao;
	
	public Questao() {
		super();
	}

	public Questao(String descricaoQuestao) {
		super();
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
	
	
	
}
