package br.com.easyfinapi.domains;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Professor {

	@Id
	private String id;
	private String nome;
	private String email;
	private String senha ;
	private List<String> idQuestoes = new ArrayList<String>();
	
	
	public Professor() {
		
	}
	


	public Professor(String id, String nome, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public void adicionaQuestao(String idReferencia) {
		this.idQuestoes.add(idReferencia);
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public List<String> getIdQuestoes() {
		return idQuestoes;
	}


	public void setIdQuestoes(List<String> idQuestoes) {
		this.idQuestoes = idQuestoes;
	}
	
	
	
	
}
