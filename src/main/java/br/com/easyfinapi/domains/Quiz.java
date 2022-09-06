

package br.com.easyfinapi.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quiz {

	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String title;
	private boolean isActive;
	
//	private Date dataInicio;
//	private Date dataLimite;
	
	private Integer idManager;
	
	
//	private List<Questao> listaQuestoes = new ArrayList<>();
	
	
	public Quiz() {
	}

	
	public Quiz(Integer id, String title, Integer idManager) {
		this.id = id;
		this.title = title;
//		this.listaQuestoes = listaQuestoes;
		this.idManager = idManager;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public Integer getIdManager() {
		return idManager;
	}


	public void setIdManager(Integer idManager) {
		this.idManager = idManager;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	


//	public List<Questao> getListaQuestoes() {
//		return listaQuestoes;
//	}

//	public void setListaQuestoes(List<Questao> listaQuestoes) {
//		this.listaQuestoes = listaQuestoes;
//	}
	
	
}
