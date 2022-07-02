package br.com.easyfinapi.domains;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document
public class Turma {
	
	@Id
	protected String id;

	protected String nome;
	protected String materia;
	
	@DBRef
	protected Professor professor;
	
	@JsonIgnore
	@DBRef
	protected List<Aluno> listaAlunos = new ArrayList();
	protected List<Prova> listaProvas = new ArrayList();
	
	// Sera acrescentado aqui uma lista de aulas!
	
	protected Date dataInicio;
	
	public Turma() {
	}
	

	public Turma(String id, Professor professor, Date dataInicio) {
		this.id = id;
		this.professor = professor;
		this.dataInicio = dataInicio;
	}
	
	
	public void addAluno(Aluno aluno) {
		this.listaAlunos.add(aluno);
	}
	
	public void addAlunos(List<Aluno> lista) {
		this.listaAlunos.addAll(lista);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Aluno> getListaAlunos() {
		return listaAlunos;
	}

	public void setListaAlunos(List<Aluno> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}

	public List<Prova> getListaProvas() {
		return listaProvas;
	}

	public void setListaProvas(List<Prova> listaProvas) {
		this.listaProvas = listaProvas;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	
	
	
	
	
}
