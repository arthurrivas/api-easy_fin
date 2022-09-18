package br.com.easyfinapi.domains;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import br.com.easyfinapi.domains.enums.Perfil;

@Entity
@PrimaryKeyJoinColumn(name="idManager")
public class Manager extends User {
	
	private String regQuiz;
	
	public Manager() {
	}

	public Manager(String regQuiz, Integer id, String name, String email, String password, Perfil perfil) {
		super(id, name, email, password, perfil);
		this.regQuiz = regQuiz;
	}
	
	public Manager(Integer id, String name, String email, String password, Perfil perfil) {
		super(id, name, email, password, perfil);
	}

	public String getRegQuiz() {
		return regQuiz;
	}

	public void setRegQuiz(String regQuiz) {
		this.regQuiz = regQuiz;
	}

	@Override
	public String toString() {
		return "Manager [getName()=" + getName() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword()
				+ ", getPerfis()=" + getPerfis() + "]";
	}

	
	
	
	
}
