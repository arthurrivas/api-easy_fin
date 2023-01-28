package br.com.easyfinapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.easyfinapi.domains.User;
import br.com.easyfinapi.repositorys.UserRepository;
import br.com.easyfinapi.security.UsuarioSS;
import br.com.easyfinapi.services.exceptions.UserNotFoundException;

@Service
public class UserServices {	
	
	@Autowired
	UserRepository userRepository;

	public UsuarioSS isAuthenticated() {
		
		UsuarioSS ss = (UsuarioSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();			
		
		if (ss == null || ss.getId() == null) throw new UserNotFoundException("usuario não encontrado");
		
		return ss;
	}

	public User findById(Integer id) {
		return userRepository.findById(id).get();
	}
	

}
