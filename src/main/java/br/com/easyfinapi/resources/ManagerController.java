package br.com.easyfinapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findManagerByid(@PathVariable(name = "id") Integer id){
		
		try {
			Manager manager = managerService.findById(id);

			return new ResponseEntity(HttpStatus.OK).ok(manager);
		
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable(name = "id") Integer id ) {
		try {
			
			managerService.deleteById(id);
			
			return ResponseEntity.noContent().build();
			
		} catch (Exception e) {
			
			return null;
		}
	}
	
	
}



















