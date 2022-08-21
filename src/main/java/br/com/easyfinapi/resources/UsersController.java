package br.com.easyfinapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easyfinapi.domains.User;
import br.com.easyfinapi.security.UsuarioSS;
import br.com.easyfinapi.services.ManagerService;
import br.com.easyfinapi.services.UserServices;

@RestController
@RequestMapping(value = "/perfil")
public class UsersController {

	@Autowired
	UserServices userService;

	@Autowired
	ManagerService managerService;

	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable(required = true, name = "id") Integer id) {
		try {
			User user = userService.findById(id);

			return new ResponseEntity<>(HttpStatus.OK).ok(user);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	public ResponseEntity<?> getInfoCurrentUser() {
		try {

			UsuarioSS ss = userService.isAuthenticated();

			User user = userService.findById(ss.getId());

			return new ResponseEntity<>(HttpStatus.OK).ok(user);

		} catch (

		Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

}
