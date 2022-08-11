package br.com.easyfinapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easyfinapi.domains.Prova;
import br.com.easyfinapi.domains.User;
import br.com.easyfinapi.security.UsuarioSS;
import br.com.easyfinapi.services.ManagerService;
import br.com.easyfinapi.services.ProvaService;
import br.com.easyfinapi.services.QuestaoService;
import br.com.easyfinapi.services.UserServices;

@RestController
@RequestMapping(value = "/prova")
public class ProvaController {

	@Autowired
	UserServices userService;

	@Autowired
	ManagerService teacherService;

	@Autowired
	ProvaService provaService;
	
	@Autowired
	QuestaoService questaoService;

//	@GetMapping
//	public ResponseEntity<?> getProvas() {
//
//		UsuarioSS ss = userService.isAuthenticated();
//
//		if (ss.getId() != null) {
//			User teacher = teacherService.findById(ss.getId());
//
//			List<Prova> listaProvas = teacher.getProvas();
//
//			return new ResponseEntity<>(HttpStatus.OK).ok(listaProvas);
//		}
//
//		return ResponseEntity.noContent().build();
//
//	}

//	@PostMapping
//	public ResponseEntity<?> addProvas(@RequestBody ProvaDTO provaDTO) {
//
//		UsuarioSS ss = userService.isAuthenticated();
//
//		Teacher teacher = new Teacher();
//
//		if (ss.getId() != null) {
//
//			teacher = teacherService.findById(ss.getId());
//
//			Prova prova = provaService.fromDTO(provaDTO, teacher.getId());
//
//			provaService.saveAll(prova);
//
//			teacher.addProva(prova);
//
//			teacherService.saveAll(Arrays.asList(teacher));
//		}
//
//		return new ResponseEntity<>(HttpStatus.OK).ok(teacher.getProvas());
//	}

//	@GetMapping(value = "/{id}")
//	public ResponseEntity<?> retornaProva(@PathVariable(value = "id") String id) {
//
//		try {
//			Prova prova = provaService.findById(id);
//			return new ResponseEntity<>(HttpStatus.OK).ok(prova);
//
//		} catch (Exception e) {
//			return ResponseEntity.noContent().build();
//		}
//	}

//	@GetMapping(value = "/{id}/questoes")
//	public ResponseEntity<?> retornaQuestoesProva(@PathVariable(value = "id") String id) {
//
//		try {
//			Prova prova = provaService.findById(id);
//			List<Questao> listaQuestoes = prova.getListaQuestoes();
//			return new ResponseEntity<>(HttpStatus.OK).ok(listaQuestoes);
//
//		} catch (Exception e) {
//			return ResponseEntity.noContent().build();
//		}
//	}
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








