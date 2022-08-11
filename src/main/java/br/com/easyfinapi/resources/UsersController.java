package br.com.easyfinapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	@GetMapping
	public ResponseEntity<?> getInfologgedUser(){
		
		UsuarioSS ss = userService.isAuthenticated();
		
		if(ss.userHasAuthority("ROLE_PROFESSOR")) {
			
			User user = userService.findByEmail(ss.getUsername());
			
			return new ResponseEntity<>(HttpStatus.OK).ok(user);
			
		}

		return null;
		
	}
	
}
