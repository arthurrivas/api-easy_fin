package br.com.easyfinapi.dtos;

import br.com.easyfinapi.domains.Users;

public class UsersDTO {

	private String id;
	private String nome;
	private String email;
	
	
	public UsersDTO() {
	}


	public UsersDTO(Users user) {
		super();
		this.id = user.getId();
		this.email = user.getEmail();
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
	
	
}
