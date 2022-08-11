package br.com.easyfinapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easyfinapi.domains.Turma;
import br.com.easyfinapi.services.AlunoService;
import br.com.easyfinapi.services.ManagerService;
import br.com.easyfinapi.services.TurmaService;

@RestController
@RequestMapping(value = "/turma")
public class TurmaController {
	
	@Autowired
	TurmaService turmaService;
	@Autowired
	ManagerService managerService;
	@Autowired
	AlunoService alunoService;
	
	
	@GetMapping
	public ResponseEntity<?> retornaTurmas(){
		
		List<Turma> listaTurmas = turmaService.retornaTurmas();
		
		return new ResponseEntity<>(HttpStatus.OK).ok(listaTurmas);
	}
	
	/*
		Apenas admins e managers poderão criar novas turmas
	*/
//	@PostMapping
//	public ResponseEntity<?> addTurma(@RequestBody CriaTurmaDTO novaTurmaDTO){
//		
//		try {
//			Teacher teacher = professorService.findByEmail(novaTurmaDTO.getEmailProf());
//			Turma turma = new Turma(null, teacher , new Date());
//			
//			turmaService.saveTurma(turma);
//			
//			teacher.addTurma(turma);
//			
//			professorService.save(teacher);
//
//			return new ResponseEntity<>(HttpStatus.CREATED).ok(turma);
//			
//		} catch (Exception e) {
//			
//			//# Adicionar tratamento de erro
//			return null;
//		}
//		
//	}
//	
//	
//	@GetMapping(value = "/{id}")
//	public ResponseEntity<?> retornaTurmaById(@PathVariable(value = "id") String id ){
//		
//		
//		try {
//			Turma turma = turmaService.findById(id);
//			return new ResponseEntity<>(HttpStatus.OK).ok(turma);
//			
//			
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT).noContent().build();
//		}
//			
//	}
//	
//	@GetMapping(value = "/{id}/alunos")
//	public ResponseEntity<?> retornaAlunosTurmaById(@PathVariable(value = "id") String id ){
//		
//		
//		try {
//			Turma turma = turmaService.findById(id);
//			return new ResponseEntity<>(HttpStatus.OK).ok(turma.getListaAlunos());
//			
//			
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT).noContent().build();
//		}
//	}
//	
//	@PostMapping(value = "/{id}/alunos/{id_aluno}")
//	public ResponseEntity<?> addAluno(@PathVariable(value = "id") String idTurma, @PathVariable(value = "id_aluno") String idAluno){
//		
//		Turma turma = turmaService.findById(idTurma);
//		turma.addAluno(alunoService.findById(idAluno));
//		
//		return new ResponseEntity<>(HttpStatus.OK).ok(turma.getListaAlunos());
//		
//	}
	
}











