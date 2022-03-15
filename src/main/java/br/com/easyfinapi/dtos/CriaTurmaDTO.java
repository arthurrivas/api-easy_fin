package br.com.easyfinapi.dtos;

public class CriaTurmaDTO {
	
	private String nome;
	private String idProfessor;
	
	public CriaTurmaDTO() {
	}
	
	public CriaTurmaDTO(String nome, String idProfessor) {
		this.nome = nome;
		this.idProfessor = idProfessor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(String idProfessor) {
		this.idProfessor = idProfessor;
	}
	
	
	
	
	
}
