package br.com.easyfinapi.dtos;

public class CreateUserDTO {

	private String name;
	private String email;
	private String password;

	public CreateUserDTO() {
	}

	public CreateUserDTO(String name, String email, String password, Integer typeUser) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}