package br.com.easyfinapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.easyfinapi.domains.Professor;
import br.com.easyfinapi.repositorys.ProfessorRepository;
import br.com.easyfinapi.security.UsuarioSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	
	@Autowired
	ProfessorRepository professorRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Professor prof = professorRepository.findByEmail(email);
		
		return new UsuarioSS(prof.getId(),prof.getEmail(),prof.getSenha(),prof.getPerfisUser());
	}

}
