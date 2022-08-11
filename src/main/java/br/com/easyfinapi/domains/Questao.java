package br.com.easyfinapi.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Questao {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String descricaoQuestao;
	
	
//	private List<Alternativa> alternativas = new ArrayList<>();
	
	
	public Questao() {
	}

	public Questao(Integer id, String descricaoQuestao) {
		this.id = id;
		this.descricaoQuestao = descricaoQuestao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricaoQuestao() {
		return descricaoQuestao;
	}

	public void setDescricaoQuestao(String descricaoQuestao) {
		this.descricaoQuestao = descricaoQuestao;
	}

//	public void setAlternativasErrada(List<Alternativa> alternativas) {
//		this.alternativas = alternativas;
//	}
//	
//	public void addAlternativa(Alternativa alternativa) {
//		this.alternativas.add(alternativa);
//	}
	
	
	
	
}
