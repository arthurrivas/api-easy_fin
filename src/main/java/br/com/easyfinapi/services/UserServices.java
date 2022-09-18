package br.com.easyfinapi.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.easyfinapi.security.UsuarioSS;

@Service
public class UserServices {	

	public UsuarioSS isAuthenticated() {
		return (UsuarioSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	

}
