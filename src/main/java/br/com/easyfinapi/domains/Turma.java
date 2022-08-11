package br.com.easyfinapi.domains;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected Integer id;

	protected String name;
	// protected String materia;
	protected Date startDate;
//
//	@ManyToOne
//	protected User teacher;

//	@JsonIgnore
//	@ManyToMany
//	protected List<User> listaAlunos = new ArrayList();
//	protected List<Prova> listaProvas = new ArrayList();

	// Sera acrescentado aqui uma lista de aulas!

	public Turma() {
	}

	public Turma(Integer id, User teacher, Date startDate) {
		this.id = id;
//		this.teacher = teacher;
		this.startDate = startDate;
	}

//	public void addAluno(User aluno) {
//		this.listaAlunos.add(aluno);
//	}
//	
//	public void addAlunos(List<User> lista) {
//		this.listaAlunos.addAll(lista);
//	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public User getTeacher() {
//		return this.teacher;
//	}
//
//	public void setProfessor(User teacher) {
//		this.teacher = teacher;
//	}

//	public List<User> getListaAlunos() {
//		return listaAlunos;
//	}
//
//	public void setListaAlunos(List<User> listaAlunos) {
//		this.listaAlunos = listaAlunos;
//	}
//
//	public List<Prova> getListaProvas() {
//		return listaProvas;
//	}
//
//	public void setListaProvas(List<Prova> listaProvas) {
//		this.listaProvas = listaProvas;
//	}

//	public Date getStartDate() {
//		return startDate;
//	}
//
//	public void setDataInicio(Date startDate) {
//		this.startDate = startDate;
//	}

}
