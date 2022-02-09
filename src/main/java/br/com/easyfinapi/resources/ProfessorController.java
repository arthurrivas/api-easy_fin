package br.com.easyfinapi.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.easyfinapi.domains.Professor;
import br.com.easyfinapi.dtos.ProfessorDTO;
import br.com.easyfinapi.security.UsuarioSS;
import br.com.easyfinapi.services.ProfessorService;
import br.com.easyfinapi.services.ProvaService;
import br.com.easyfinapi.services.UserServices;

@RestController
@RequestMapping(value = "/professor")
public class ProfessorController {

	@Autowired
	UserServices userService;

	@Autowired
	ProfessorService professorService;

	@Autowired
	ProvaService provaService;

	@PostMapping
	public ResponseEntity<?> criaProfessor(@RequestBody ProfessorDTO professorDTO) {

		Professor prof = professorService.fromProfessorDTO(professorDTO);

		professorService.criaProfessor(prof);

		return new ResponseEntity<Professor>(HttpStatus.CREATED).ok(prof);

	}

	@GetMapping
	public ResponseEntity<?> retornaProfessores(@RequestParam(value = "email", required = false) String email) {
		
		if (email.equals(null)) {
			List<Professor> listaProfessores = professorService.findAll();

			return new ResponseEntity<>(HttpStatus.OK).ok(listaProfessores);

		}
		
		
		Professor prof;
		try {
			prof = professorService.findByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.noContent().build();
		}
		
		return new ResponseEntity<>(HttpStatus.OK).ok(prof);
		
	}

	@PutMapping
	public ResponseEntity<?> atualizaProfessor(@RequestBody ProfessorDTO profDTO) {

		UsuarioSS ss = userService.isAuthenticated();

		if (ss.getId() != null) {
			Professor prof = professorService.findById(ss.getId());

			prof.setEmail(profDTO.getEmail());
			prof.setNome(profDTO.getNome());
			prof.setSenha(prof.getSenha());

			professorService.saveAll(Arrays.asList(prof));

			return new ResponseEntity<>(HttpStatus.ACCEPTED).ok(prof);
		}

		return null;
	}
	
	
	// Apenas Admim 
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> listaProfById(@PathVariable(value = "id")String id ){
		try {
			Professor prof = professorService.findById(id);
			return new ResponseEntity<>(HttpStatus.OK).ok(prof);
		
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping("/{id}/provas")
	public ResponseEntity<?> listaProvasByIdProfessor(@PathVariable(value = "id")String id ){
		try {
			Professor prof = professorService.findById(id);
			
			
			
			return new ResponseEntity<>(HttpStatus.OK).ok(prof.getProvas());
		
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	
	
	
	
	
	
	
}
