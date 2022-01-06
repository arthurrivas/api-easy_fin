package br.com.easyfinapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easyfinapi.domains.Professor;
import br.com.easyfinapi.repositorys.ProfessorRepository;
@Service
public class ProfessorService {
	
	@Autowired
	ProfessorRepository professorRepository;
	
	public Optional<Professor> findById(String id) {
		Optional<Professor> professor = professorRepository.findById(id);
		return professor;
	}
	public List<Professor> findAll() {
		return professorRepository.findAll();
	}
	
	public void saveAll(List<Professor> lista) {
		
		professorRepository.saveAll(lista);
	}
	
	public void deleteAll() {
		professorRepository.deleteAll();
	}
	
}	
