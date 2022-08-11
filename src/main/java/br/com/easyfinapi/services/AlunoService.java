package br.com.easyfinapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easyfinapi.repositorys.UserRepository;

@Service
public class AlunoService {
	
	@Autowired
	UserRepository userRepository;
	
}
