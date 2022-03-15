package br.com.easyfinapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easyfinapi.domains.Questao;
import br.com.easyfinapi.dtos.QuestaoDTO;
import br.com.easyfinapi.repositorys.questaoRepository;

@Service
public class QuestaoService {
	
	@Autowired
	questaoRepository questaoRepository;
	
	
	public Questao fromDTO(QuestaoDTO questaoDTO) {
		
		return new Questao(null,questaoDTO.getDescricaoQuestao());
	}
	
	
	
}
