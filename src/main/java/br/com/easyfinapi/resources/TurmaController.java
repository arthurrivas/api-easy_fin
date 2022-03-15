package br.com.easyfinapi.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easyfinapi.domains.Professor;
import br.com.easyfinapi.domains.Turma;
import br.com.easyfinapi.dtos.CriaTurmaDTO;
import br.com.easyfinapi.services.AlunoService;
import br.com.easyfinapi.services.ProfessorService;
import br.com.easyfinapi.services.TurmaService;

@RestController
@RequestMapping(value = "/turma")
public class TurmaController {
	
	@Autowired
	TurmaService turmaService;
	@Autowired
	ProfessorService professorService;
	@Autowired
	AlunoService alunoService;
	
	
	@GetMapping
	public ResponseEntity<?> retornaTurmas(){
		
		List<Turma> listaTurmas = turmaService.retornaTurmas();
		
		return new ResponseEntity<>(HttpStatus.OK).ok(listaTurmas);
	}
	
	/*
		Apenas admins ou diretores poderão criar novas turmas
	*/
	@PostMapping
	public ResponseEntity<?> addTurma(@RequestBody CriaTurmaDTO novaTurmaDTO){
		
		
		Professor prof = professorService.findById(novaTurmaDTO.getIdProfessor());
		Turma turma = new Turma(null, prof , new Date());
		
		turmaService.saveTurma(turma);
		
		prof.addTurma(turma);
		
		professorService.save(prof);

		return new ResponseEntity<>(HttpStatus.CREATED).ok(turma);
		
		
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> retornaTurmaById(@PathVariable(value = "id") String id ){
		
		
		try {
			Turma turma = turmaService.findById(id);
			return new ResponseEntity<>(HttpStatus.OK).ok(turma);
			
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT).noContent().build();
		}
			
	}
	
	@GetMapping(value = "/{id}/alunos")
	public ResponseEntity<?> retornaAlunosTurmaById(@PathVariable(value = "id") String id ){
		
		
		try {
			Turma turma = turmaService.findById(id);
			return new ResponseEntity<>(HttpStatus.OK).ok(turma.getListaAlunos());
			
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT).noContent().build();
		}
	}
	
	@PostMapping(value = "/{id}/alunos/{id_aluno}")
	public ResponseEntity<?> addAluno(@PathVariable(value = "id") String idTurma, @PathVariable(value = "id_aluno") String idAluno){
		
		Turma turma = turmaService.findById(idTurma);
		turma.addAluno(alunoService.findById(idAluno));
		
		return new ResponseEntity<>(HttpStatus.OK).ok(turma.getListaAlunos());
		
	}
	
}











