package br.com.easyfinapi.resources;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
import br.com.easyfinapi.domains.Prova;
import br.com.easyfinapi.dtos.ProvaDTO;
import br.com.easyfinapi.security.UsuarioSS;
import br.com.easyfinapi.services.ProfessorService;
import br.com.easyfinapi.services.ProvaService;
import br.com.easyfinapi.services.UserServices;

@RestController
@RequestMapping(value = "/prova")
public class ProvaController {
	
	@Autowired
	UserServices userService;
	
	@Autowired
	ProfessorService professorService;
	
	@Autowired
	ProvaService provaService;
	
	@GetMapping
	public ResponseEntity<?> getProvas(){
		
		UsuarioSS ss = userService.isAuthenticated();
		
		if(ss.getId() != null) {
			Professor prof = professorService.findById(ss.getId());
			
			List<Prova> listaProvas = prof.getProvas();
			
			return new ResponseEntity<>(HttpStatus.OK).ok(listaProvas);	
		}
		
			return ResponseEntity.noContent().build();
		
	}
	@PostMapping
	public ResponseEntity<?> addProvas(@RequestBody ProvaDTO provaDTO){
		
		UsuarioSS ss = userService.isAuthenticated();
		
		Professor prof = new Professor();
		
		if(ss.getId() != null  ) {
			
			prof = professorService.findById(ss.getId());
			
			Prova prova = provaService.fromDTO(provaDTO);
			provaService.saveAll(prova);
			
			prof.adicionaProva(prova);
					
			professorService.saveAll(Arrays.asList(prof));
		}
		
		
		return new ResponseEntity<>(HttpStatus.OK).ok(prof.getProvas());		
	}
	
	
	
	
	
}
