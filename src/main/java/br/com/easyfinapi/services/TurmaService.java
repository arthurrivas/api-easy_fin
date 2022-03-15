package br.com.easyfinapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easyfinapi.domains.Turma;
import br.com.easyfinapi.repositorys.TurmaRepository;

@Service
public class TurmaService {
	
	
	@Autowired
	TurmaRepository turmaRepository;
	
	public List<Turma> retornaTurmas(){		
		return turmaRepository.findAll();
	}
	
	public Turma findById(String id) {
		return turmaRepository.findById(id).get();
	}
	
	public void saveTurma(Turma turma) {
		turmaRepository.save(turma);
	}
	
}
