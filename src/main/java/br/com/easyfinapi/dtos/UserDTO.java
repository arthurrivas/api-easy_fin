package br.com.easyfinapi.dtos;

import br.com.easyfinapi.domains.User;

public class UserDTO {

	private Integer id;
	private String name;
	private String email;
	
	
	public UserDTO() {
	}


	public UserDTO(User user) {
		super();
		this.id = user.getId();
		this.email = user.getEmail();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setNome(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
