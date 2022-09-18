package br.com.easyfinapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.easyfinapi.domains.User;
import br.com.easyfinapi.repositorys.ManagerRepository;
import br.com.easyfinapi.repositorys.UserRepository;
import br.com.easyfinapi.security.UsuarioSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(email);
		
		if (user != null) return new UsuarioSS(user.getId(),user.getEmail(),user.getPassword(),user.getPerfis());
									
		return null;
	}

}
