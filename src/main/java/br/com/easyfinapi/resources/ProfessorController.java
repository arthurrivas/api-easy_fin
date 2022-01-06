package br.com.easyfinapi.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easyfinapi.domains.Professor;
import br.com.easyfinapi.dtos.QuestaoDTO;
import br.com.easyfinapi.services.ProfessorService;

@RestController
@RequestMapping(value = "/professores")
public class ProfessorController {
	
	@Autowired
	ProfessorService professorService;
	
	@GetMapping
	public ResponseEntity<List<Professor>> listaProfessores(){
		
		List<Professor> listaProfessor = professorService.findAll();
		
		return ResponseEntity.ok().body(listaProfessor);
		
	}
	
	@GetMapping(value = "/questoes")
	public void criaQUestao(@RequestBody String idProfessor, @RequestBody QuestaoDTO novaQuestao){
		
		Optional<Professor> professorOptional = professorService.findById(idProfessor);
		Professor professor = professorOptional.get();
		
		
		System.out.print(professor.getNome());
		
		
		//professor.setIdQuestoes()
		
	}
	
	
	
	
	
	
}
