package br.com.easyfinapi.resources;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easyfinapi.domains.Users;
import br.com.easyfinapi.dtos.UsersDTO;
import br.com.easyfinapi.services.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UsersController {
	
	@Autowired
	private UserServices userServices;
	
	@GetMapping
	public ResponseEntity<?> retornaUsuarios(){
		
		List<Users> listaUsuarios = userServices.findall();
		
		List<UsersDTO> listaDTO = listaUsuarios.stream().map(x -> new UsersDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listaDTO);
		
	}
	
}
