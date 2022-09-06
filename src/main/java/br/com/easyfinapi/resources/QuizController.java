package br.com.easyfinapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easyfinapi.domains.Quiz;
import br.com.easyfinapi.dtos.QuizDTO;
import br.com.easyfinapi.security.UsuarioSS;
import br.com.easyfinapi.services.ManagerService;
import br.com.easyfinapi.services.QuizService;
import br.com.easyfinapi.services.UserServices;

@RestController
@RequestMapping(value = "/quiz")
public class QuizController {

	@Autowired
	UserServices userService;

	@Autowired
	ManagerService teacherService;

	@Autowired
	QuizService quizService;
	
	@PostMapping
	public ResponseEntity<?> createQuiz(@RequestBody QuizDTO quizDTO){
		
		try {
			
			UsuarioSS ss = userService.isAuthenticated();
			
			if (ss.getId() != null){
				
				
				Quiz quiz = quizService.fromDTO(quizDTO, ss.getId());
				
				quizService.save(quiz);
				
				return new ResponseEntity<Quiz>(HttpStatus.CREATED);
			}
			
			return ResponseEntity.noContent().build();
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.noContent().build();
		}		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable(value = "id") Integer id ){
		try {
			
			Quiz quiz = quizService.findById(id);
			
			return new ResponseEntity<>(HttpStatus.OK).ok(quiz);
			
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
			// TODO: handle exception
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateById(@PathVariable(value = "id") Integer id, @RequestBody QuizDTO quizDTO ){
		try {
			
			UsuarioSS ss = userService.isAuthenticated();
			Quiz quiz = quizService.findById(id);
			
			
			if(ss.getId() != null && ss.getId() == quiz.getId()) {
				quizService.update(quiz, quizDTO);
			}
			
			return new ResponseEntity<>(HttpStatus.OK).ok(quiz);
			
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
			// TODO: handle exception
		}
	}


//
//	@PostMapping(value = "/{id}/questoes")
//	public ResponseEntity<?> addQuestaoProva(@PathVariable(value = "id") String id, QuestaoDTO questaoDTO) {
//
//		UsuarioSS ss = userService.isAuthenticated();
//		Prova prova = provaService.findById(id);
//
//		if (ss.getId() != prova.getId()) {
//			try {
//				
//				Questao questao = questaoService.fromDTO(questaoDTO);
//				
//				prova.adicionaQuestao(questao);
//				
//				provaService.saveAll(prova);
//				
//				return new ResponseEntity<>(HttpStatus.OK).ok(prova);
//
//			} catch (Exception e) {
//				return ResponseEntity.noContent().build();
//			}
//		}
//		return ResponseEntity.noContent().build();
//	}
//
//	@DeleteMapping(value = "/{idProva}/questao/{idQuestao}")
//	public ResponseEntity<?> deletaQuestao(@PathVariable(value = "id")String idProva, 
//											@PathVariable(value = "idQuestao")String idQuestao ){
//		
//		Prova prova = provaService.findById(idProva);
//		//precisa ser implementado a função de deletar a questão usando o id dela		
//		
//		return new ResponseEntity(HttpStatus.NO_CONTENT).noContent().build();
//	}
}








