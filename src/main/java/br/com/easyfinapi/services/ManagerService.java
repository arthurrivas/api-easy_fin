package br.com.easyfinapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.datatype.jsr310.deser.key.PeriodKeyDeserializer;

import br.com.easyfinapi.domains.Manager;
import br.com.easyfinapi.domains.User;
import br.com.easyfinapi.domains.DTO.ManagerDTO;
import br.com.easyfinapi.domains.enums.Perfil;
import br.com.easyfinapi.repositorys.ManagerRepository;

@Service
public class ManagerService {
	
	
	@Autowired
	ManagerRepository managerRepository;
	
	@Autowired
	BCryptPasswordEncoder pe;
	
	
	public Manager findById(Integer id) {
		Optional<User> manager = managerRepository.findById(id);
		
		return (Manager) manager.get();
	}
	
	public Manager save(Manager manager) {
		
		 managerRepository.save(manager);
		 
		 return manager;
	}
	
	
	public Manager fromDTO(ManagerDTO managerDTO) {
		return new Manager(null, managerDTO.getName(), managerDTO.getEmail(), pe.encode(managerDTO.getPassword()),Perfil.MANAGER);
	}
	
	
}
