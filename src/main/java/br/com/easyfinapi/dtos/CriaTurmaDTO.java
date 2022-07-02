package br.com.easyfinapi.dtos;

public class CriaTurmaDTO {
	
	private String nome;
	private String materia;
	private String emailProf;
	
	public CriaTurmaDTO() {
	}
	
	public CriaTurmaDTO(String nome,String materia, String emailProf) {
		this.nome = nome;
		this.materia = materia;
		this.emailProf = emailProf;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getEmailProf() {
		return emailProf;
	}

	public void setEmailProf(String emailProf) {
		this.emailProf = emailProf;
	}
	
}
