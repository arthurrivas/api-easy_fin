package br.com.easyfinapi.dtos;



public class CredenciaisDTO {
	
	
	private String email;
	private String password;
	
	public CredenciaisDTO() {
	}
	
	public CredenciaisDTO(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
}
