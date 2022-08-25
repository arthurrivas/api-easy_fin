package br.com.easyfinapi.dtos;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CreateUserDTO {

	@NotBlank(message = "Nome não pode estar vazio")
	private String name;
	
	@Email(message = "Email invalido")
	private String email;
	
	@Min(value = 4, message = "Senha tem que ter mais de 4 caracteres")
	private String password;
	

	public CreateUserDTO() {
	}

	public CreateUserDTO(String name, String email, String password, Date birthDate) {
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
