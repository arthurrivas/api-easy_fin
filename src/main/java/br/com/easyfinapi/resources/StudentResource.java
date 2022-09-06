package br.com.easyfinapi.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easyfinapi.domains.User;
import br.com.easyfinapi.domains.enums.Perfil;
import br.com.easyfinapi.dtos.CreateUserDTO;
import br.com.easyfinapi.services.UserServices;

@RestController
@RequestMapping(value = "/student")
public class StudentResource {

	@Autowired
	UserServices userService;

	@PostMapping()
	public ResponseEntity<?> createStudent(@Valid @RequestBody CreateUserDTO userDTO) {
		try {
			User user = userService.fromUserDTO(userDTO, Perfil.STUDENT.getCodPerfil());

			userService.Save(user);

			System.out.println(user);

			return new ResponseEntity<>(HttpStatus.OK).ok(user);

		} catch (Exception e) {
			
			return ResponseEntity.badRequest().build();
			
		}
	}

}
