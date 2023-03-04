package br.com.easyfinapi.services;

import java.util.List;
import java.util.Optional;

import br.com.easyfinapi.domains.enums.Perfil;
import br.com.easyfinapi.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.easyfinapi.domains.User;
import br.com.easyfinapi.repositorys.UserRepository;
import br.com.easyfinapi.security.UsuarioSS;
import br.com.easyfinapi.services.exceptions.UserNotFoundException;

@Service
public class UserServices {	
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder pe;

	public UsuarioSS isAuthenticated() {
		
		UsuarioSS ss = (UsuarioSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();			
		
		if (ss == null || ss.getId() == null) throw new UserNotFoundException("usuario não encontrado");
		
		return ss;
	}

	public User findById(Integer id) {

		Optional<User> opt = userRepository.findById(id); 
		
		if (!opt.isPresent()) throw new UserNotFoundException("Usuario nao encontrado");

		return opt.get();
	}
	
	public void save(User user){
		userRepository.save(user);
	}

    public List<User> getUsers() {
		return userRepository.findAll();
    }

	public void deleteById(Integer id){
		userRepository.deleteById(id);
	}

	public User fromDTO(UserDTO userDTO){
		return new User(userDTO.getId(),userDTO.getName(), userDTO.getEmail(), userDTO.getPhone(), pe.encode(userDTO.getPassword()), Perfil.toEnum(userDTO.getCodProfile()));
	}

}
