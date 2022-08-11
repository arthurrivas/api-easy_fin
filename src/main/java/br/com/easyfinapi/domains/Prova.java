package br.com.easyfinapi.domains;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prova {

	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String titulo;
	
//	private Date dataInicio;
//	private Date dataLimite;
	
	private String idProfessorCriador;
	
	
//	private List<Questao> listaQuestoes = new ArrayList<>();
	
	
	public Prova() {
	}

	
	public Prova(Integer id, String titulo, List<Questao> listaQuestoes, String idProfessor) {
		this.id = id;
		this.titulo = titulo;
//		this.listaQuestoes = listaQuestoes;
		this.idProfessorCriador = idProfessor;
	}


//	public void adicionaQuestao(Questao questao) {
//		this.listaQuestoes.add(questao);
//	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
	public String getIdProfessorCriador() {
		return idProfessorCriador;
	}


	public void setIdProfessorCriador(String idProfessorCriador) {
		this.idProfessorCriador = idProfessorCriador;
	}


//	public List<Questao> getListaQuestoes() {
//		return listaQuestoes;
//	}

//	public void setListaQuestoes(List<Questao> listaQuestoes) {
//		this.listaQuestoes = listaQuestoes;
//	}
	
	
}
