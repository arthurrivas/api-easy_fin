package br.com.easyfinapi.resources;

import br.com.easyfinapi.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@PostMapping()
	public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO){

		User user = userService.fromDTO(userDTO);

		userService.save(user);

		return new ResponseEntity(user, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateUser(@PathVariable(name = "id") Integer id, @RequestBody UserDTO userDTO){

		User user = userService.fromDTO(userDTO);

		userService.save(user);

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(name = "id") Integer id){

		userService.deleteById(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}



}