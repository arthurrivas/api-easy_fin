package br.com.easyfinapi.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Alternativa {
	
	@Id
	private String id;
	private String descricao;
	private boolean correta;
	
	public Alternativa() {
	}
	
	public Alternativa(String id, String descricao, boolean correta) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.correta = correta;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isCorreta() {
		return correta;
	}

	public void setCorreta(boolean correta) {
		this.correta = correta;
	}
	
	
	
	

}
