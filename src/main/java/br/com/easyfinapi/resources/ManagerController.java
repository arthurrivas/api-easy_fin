package br.com.easyfinapi.resources;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easyfinapi.domains.User;
import br.com.easyfinapi.domains.enums.Perfil;
import br.com.easyfinapi.dtos.CreateUserDTO;
import br.com.easyfinapi.services.ProvaService;
import br.com.easyfinapi.services.UserServices;

@RestController
@RequestMapping(value = "/manager")
public class ManagerController {

	@Autowired
	UserServices userService;

	@Autowired
	ProvaService provaService;

	@PostMapping
	public ResponseEntity<?> createManager(@Valid @RequestBody CreateUserDTO managerDTO) {

		User manager = userService.fromUserDTO(managerDTO, Perfil.MANAGER.getCodPerfil());
		
		userService.SaveAll(Arrays.asList(manager));

		return new ResponseEntity<User>(HttpStatus.CREATED).ok(manager);

	}

//	@GetMapping
//	public ResponseEntity<?> getManagers() {
//
//		List<User> managerList = userService.findAll();
//
//		return new ResponseEntity<>(HttpStatus.OK).ok(managerList);
//
//	}

//	@GetMapping("/{id}/provas")
//	public ResponseEntity<?> listaProvasByIdProfessor(@PathVariable(value = "id") Integer id) {
//		 
//		try {
//
//			User manager = userService.findById(id);
//
//			return new ResponseEntity<>(HttpStatus.OK).ok(manager.getProvas());
//
//		} catch (Exception e) {
//			return ResponseEntity.noContent().build();
//		}
//
//	}

}
