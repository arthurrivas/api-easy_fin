package br.com.easyfinapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easyfinapi.domains.User;
import br.com.easyfinapi.dtos.CreateUserDTO;
import br.com.easyfinapi.security.UsuarioSS;
import br.com.easyfinapi.services.ManagerService;
import br.com.easyfinapi.services.UserServices;

@RestController
@RequestMapping(value = "/user")
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

	@PutMapping("/{id}")
	public ResponseEntity<?> updateInfoUser(@PathVariable(name = "id") Integer id,@RequestBody CreateUserDTO userUpdate) {
		try {

			UsuarioSS ss = userService.isAuthenticated();
			
			if (ss.getId() == id || ss.userHasAuthority("ADMIN")) {

				User user = userService.update(id, userUpdate);

				return new ResponseEntity<>(HttpStatus.OK).ok(user);

			}

			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not Authorized");

		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id ){
		
		userService.deleteById(id);
		
		return ResponseEntity.noContent().build();

	}

	@GetMapping("/current-user")
	public ResponseEntity<?> getInfoCurrentUser() {
		try {

			UsuarioSS ss = userService.isAuthenticated();

			User user = userService.findById(ss.getId());

			return new ResponseEntity<>(HttpStatus.OK).ok(user);

		} catch (

		Exception e) {
			return ResponseEntity.notFound().build();
		}

	}

}
