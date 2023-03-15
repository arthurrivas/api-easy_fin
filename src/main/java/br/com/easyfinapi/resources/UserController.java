package br.com.easyfinapi.resources;

import br.com.easyfinapi.domains.Address;
import br.com.easyfinapi.domains.City;
import br.com.easyfinapi.domains.enums.Perfil;
import br.com.easyfinapi.dtos.UserDTO;
import br.com.easyfinapi.services.AddressService;
import br.com.easyfinapi.services.CityService;
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

	@Autowired
	AddressService addressService;
	@Autowired
	CityService cityService;

	@GetMapping
	public ResponseEntity<List<User>> getUsers() {

		List<User> users = userService.getUsers();

		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping(value = "/current")
	public ResponseEntity<User> getCurrentUser() {

		UsuarioSS ss = userService.isAuthenticated();

		User user = userService.findById(ss.getId());

		return ResponseEntity.ok(user);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(name = "id") Integer id) {

		User user = userService.findById(id);

		return new ResponseEntity<>(user, HttpStatus.OK);

	}

	@PostMapping(value = "/student")
	public ResponseEntity<User> createStudent(@RequestBody UserDTO userDTO){

		User user = userService.fromDTO(userDTO);

		userService.save(user);

		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@PostMapping(value = "/manager")
	public ResponseEntity<User> createManager(@RequestBody UserDTO userDTO){

		User user = userService.fromDTO(userDTO);
		user.addPerfil(Perfil.ROLE_MANAGER);

		City city = cityService.findById(userDTO.getAddress().getCity().getId());
		Address address = addressService.fromDTO(userDTO.getAddress());
		address.setCity(city);
		addressService.save(address);

		user.setAddress(address);
		userService.save(user);

		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(name = "id") Integer id, @RequestBody UserDTO userDTO){

		User user = userService.fromDTO(userDTO);

		userService.save(user);

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") Integer id){

		userService.deleteById(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}



}