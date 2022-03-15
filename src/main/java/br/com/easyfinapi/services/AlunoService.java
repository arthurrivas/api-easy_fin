package br.com.easyfinapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easyfinapi.domains.Aluno;
import br.com.easyfinapi.repositorys.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	public Aluno findByEmail(String email) {
		
		return alunoRepository.findByEmail(email);
		
	}
	
	public Aluno findById(String id) {
		return alunoRepository.findById(id).get();
	}
	
}
