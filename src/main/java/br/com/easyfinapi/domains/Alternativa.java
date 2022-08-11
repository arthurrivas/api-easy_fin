package br.com.easyfinapi.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alternativa {
	
	@Id()
	@GeneratedValue(strategy =GenerationType.SEQUENCE )
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
