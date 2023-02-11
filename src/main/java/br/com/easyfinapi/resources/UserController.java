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
import br.com.easyfinapi.services.UserServices;

import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserController {

	@Autowired
	UserServices userService;

	@GetMapping
	public ResponseEntity<?> getUsers() {

		List<User> users = userService.getUsers();

		return new ResponseEntity(users, HttpStatus.OK);
	}

	@GetMapping(value = "/current")
	public ResponseEntity<?> getCurrentUser() {

		UsuarioSS ss = userService.isAuthenticated();

		User user = userService.findById(ss.getId());

		return ResponseEntity.ok(user);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getUserById(@PathVariable(name = "id") Integer id) {

		User user = userService.findById(id);

		return new ResponseEntity<>(user, HttpStatus.OK);

	}


}