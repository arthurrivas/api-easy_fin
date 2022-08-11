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

	public void deleteAll() {
		userRepository.deleteAll();
	}

	public User fromUserDTOToManager(CreateUserDTO managerDTO, Perfil perfil) {
		return new User(null, managerDTO.getName(), managerDTO.getEmail(), pe.encode(managerDTO.getPassword()), perfil);
	}

	public UsuarioSS isAuthenticated() {
		return (UsuarioSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	

}
