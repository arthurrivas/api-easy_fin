package br.com.easyfinapi.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.easyfinapi.domains.Professor;
import br.com.easyfinapi.dtos.ProfessorDTO;
import br.com.easyfinapi.repositorys.ProfessorRepository;
@Service
public class ProfessorService {
	
	@Autowired
	ProfessorRepository professorRepository;
	
	@Autowired
	BCryptPasswordEncoder pe;
	
	public void criaProfessor(Professor prof) {
		professorRepository.saveAll(Arrays.asList(prof));
	}
	
	public void save(Professor prof) {
		professorRepository.save(prof);
	}
	
	
	public void atualizaProfessor(String id, ProfessorDTO professorDTO) {
		Professor professor = findById(id);
		
	}
	
	public Professor findById(String id) {
		Optional<Professor> professor = professorRepository.findById(id);
		return professor.get();
	}
	
	public Professor findByEmail(String email) {
		return professorRepository.findByEmail(email);
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
	
	public Professor fromProfessorDTO(ProfessorDTO professorDTO) {
		return new Professor(null,professorDTO.getNome(),professorDTO.getEmail(),pe.encode(professorDTO.getSenha()));
	}

	
	
}	
