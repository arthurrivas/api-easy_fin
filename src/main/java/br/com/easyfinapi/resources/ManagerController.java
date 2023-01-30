package br.com.easyfinapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easyfinapi.domains.Manager;
import br.com.easyfinapi.domains.enums.Perfil;
import br.com.easyfinapi.dtos.NewUserDTO;
import br.com.easyfinapi.security.UsuarioSS;
import br.com.easyfinapi.services.ManagerService;
import br.com.easyfinapi.services.UserServices;

@RestController
@RequestMapping(value = "/manager")
public class ManagerController {

	@Autowired
	ManagerService managerService;

	@Autowired
	UserServices userService;

	@PostMapping
	public ResponseEntity<?> createManager(@RequestBody NewUserDTO managerDTO) {

		Manager manager = managerService.fromDTO(managerDTO);

		managerService.save(manager);

		return new ResponseEntity<>(HttpStatus.CREATED).ok(manager);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findManagerByid(@PathVariable(name = "id") Integer id) {

		Manager manager = managerService.findById(id);

		return new ResponseEntity(HttpStatus.OK).ok(manager);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateManager(@PathVariable(name = "id") Integer id, @RequestBody NewUserDTO managerDTO) {
		try {
			UsuarioSS ss = userService.isAuthenticated();
			if (ss.getId() == id || ss.getAuthorities().contains(Perfil.ROLE_ADMIN)) {

				Manager manager = managerService.fromDTO(managerDTO);
				manager.setId(id);

				managerService.save(manager);

				return new ResponseEntity(HttpStatus.OK).ok(manager);
			}

			return new ResponseEntity(HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable(name = "id") Integer id) {
		try {

			managerService.deleteById(id);

			return ResponseEntity.noContent().build();

		} catch (Exception e) {

			return null;
		}
	}

}
