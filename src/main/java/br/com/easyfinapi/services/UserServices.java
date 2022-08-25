package br.com.easyfinapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.easyfinapi.domains.User;
import br.com.easyfinapi.domains.enums.Perfil;
import br.com.easyfinapi.dtos.CreateUserDTO;
import br.com.easyfinapi.repositorys.UserRepository;
import br.com.easyfinapi.security.UsuarioSS;

@Service
public class UserServices {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder pe;
	
	public User findById(Integer id) {
		Optional<User> user = userRepository.findById(id);
		return user.get();
	}
	public User findByEmail(String email) {

		return userRepository.findByEmail(email);

	}

	public List<User> findAll() {

		return userRepository.findAll();
	}
	
	
	public void SaveAll(List<User> lista) {
		userRepository.saveAll(lista);
	}
	
	public void Save(User user) {
		userRepository.save(user);
	}
	
	public User update(Integer id, CreateUserDTO newData) {
		
		User user = findById(id);
		
		user.setEmail(newData.getEmail());
		user.setName(newData.getName());
		user.setPassword(newData.getPassword());
		
		Save(user);
		
		return user;
	}
	
	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}

	public void deleteAll() {
		userRepository.deleteAll();
	}

	public User fromUserDTO(CreateUserDTO userDTO, Integer perfilId) {
		return new User(null, userDTO.getName(), userDTO.getEmail(), pe.encode(userDTO.getPassword()), Perfil.toEnum(perfilId));
	}
	

	public UsuarioSS isAuthenticated() {
		return (UsuarioSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	

}
