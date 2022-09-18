package br.com.easyfinapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easyfinapi.domains.Manager;
import br.com.easyfinapi.domains.DTO.ManagerDTO;
import br.com.easyfinapi.services.ManagerService;

@RestController
@RequestMapping(value = "/manager")
public class ManagerController {
	
	@Autowired
	ManagerService managerService;
	
	
	@PostMapping
	public ResponseEntity<?> createManager(@RequestBody ManagerDTO managerDTO){
		
		Manager manager = managerService.fromDTO(managerDTO);
		
		managerService.save(manager);
		
		
		return new ResponseEntity<>(HttpStatus.CREATED).ok(manager);
		
	}
	
}
