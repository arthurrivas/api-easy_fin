package br.com.easyfinapi.domains;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.easyfinapi.domains.enums.Perfil;

@Document
public class Professor extends Users {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@DBRef
	private List<Prova> provas = new ArrayList<>();
	
	
	public Professor(){
		
	}
	
	public Professor(String id, String nome, String email, String senha) {
		super(id,nome, email,senha, Perfil.ROLE_PROFESSOR);
		
	}

	public void adicionaProva(Prova idReferencia) {
		this.provas.add(idReferencia);
	}


	public List<Prova> getProvas() {
		return provas;
	}


	public void setProvas(List<Prova> idQuestoes) {
		this.provas = idQuestoes;
	}

	@Override
	public String toString() {
		return "Professor " + 
				super.getNome() +
				super.getEmail() +
				super.getPerfisUser();
	}	
	
}
