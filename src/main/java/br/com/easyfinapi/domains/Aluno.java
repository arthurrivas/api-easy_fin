package br.com.easyfinapi.domains;

import org.springframework.data.mongodb.core.mapping.Document;

import br.com.easyfinapi.domains.enums.Perfil;

@Document
public class Aluno extends Users {
	

	public Aluno(){
	}
	
	public Aluno(String id,String nome, String email, String senha) {
		super(id,nome,email,senha,Perfil.ROLE_ALUNO);
	}
	
}
