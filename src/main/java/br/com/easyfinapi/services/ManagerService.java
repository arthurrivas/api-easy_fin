package br.com.easyfinapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.easyfinapi.domains.Manager;
import br.com.easyfinapi.domains.User;
import br.com.easyfinapi.domains.enums.Perfil;
import br.com.easyfinapi.dtos.NewUserDTO;
import br.com.easyfinapi.repositorys.ManagerRepository;
import br.com.easyfinapi.services.exceptions.ObjectNotFoundException;

@Service
public class ManagerService {
	
	
	@Autowired
	ManagerRepository managerRepository;
	
	@Autowired
	BCryptPasswordEncoder pe;
	
	
	public Manager findById(Integer id) {
		Optional<User> manager = managerRepository.findById(id);
		
		if (manager == null) throw new ObjectNotFoundException("manager not found");
		
		return (Manager) manager.get();
	}
	
	public Manager save(Manager manager) {
		
		 managerRepository.save(manager);
		 
		 return manager;
	}
	
	public void deleteById(Integer id ) {
		managerRepository.deleteById(id);
	}
	
	public Manager fromDTO(NewUserDTO userDTO) {
		return new Manager(null, userDTO.getName(), userDTO.getEmail(),userDTO.getPhone(), pe.encode(userDTO.getPassword()) ,Perfil.ROLE_MANAGER);
	}
	
	
	
}
