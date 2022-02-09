package br.com.easyfinapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.easyfinapi.domains.Users;
import br.com.easyfinapi.repositorys.UsersRepository;
import br.com.easyfinapi.security.UsuarioSS;

@Service
public class UserServices {
	
	@Autowired
	private UsersRepository usersRepository;
	
	public List<Users> findall(){
		
		return usersRepository.findAll();
	}
	
	public void SaveAll(List<Users> lista ){
		usersRepository.saveAll(lista);
	}
	
	public void deleteAll(){
		usersRepository.deleteAll();
	}
	
	public UsuarioSS isAuthenticated() {
		return (UsuarioSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	
}
