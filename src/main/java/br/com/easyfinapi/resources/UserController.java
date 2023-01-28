package br.com.easyfinapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easyfinapi.domains.User;
import br.com.easyfinapi.security.UsuarioSS;
import br.com.easyfinapi.services.UserServices;

@RestController
@RequestMapping(value = "user")
public class UserController {

	@Autowired
	UserServices userService;

	@GetMapping(value = "/current")
	public ResponseEntity<?> getCurrentUser() {
		
		UsuarioSS ss = userService.isAuthenticated();
		
		User user = userService.findById(ss.getId());

		System.out.println(user);
		
		return new ResponseEntity<>(HttpStatus.OK).ok(user);

	}

}
