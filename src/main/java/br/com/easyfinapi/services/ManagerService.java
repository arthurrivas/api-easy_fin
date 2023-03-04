package br.com.easyfinapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
	
	@Autowired
	BCryptPasswordEncoder pe;
	

//	public User fromDTO(NewUserDTO userDTO) {
//		return new Manager(null, userDTO.getName(), userDTO.getEmail(),userDTO.getPhone(), pe.encode(userDTO.getPassword()) ,Perfil.ROLE_MANAGER);
//	}
	
	
	
}
