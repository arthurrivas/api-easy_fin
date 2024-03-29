package br.com.easyfinapi.security;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.easyfinapi.domains.enums.Perfil;

public class UsuarioSS implements UserDetails {

	private Integer id;
	private String email;
	private String senha;
	private Collection<? extends GrantedAuthority> authorities;

	public UsuarioSS() {
	}

	public UsuarioSS(Integer id, String email, String senha, Set<Perfil> authorities) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.authorities = authorities.stream().map(x -> new SimpleGrantedAuthority(x.toString()))
				.collect(Collectors.toList());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public boolean userHasAuthority(String authority) {
		
		Collection<? extends GrantedAuthority> authorities = this.getAuthorities();

		for (GrantedAuthority grantedAuthority : authorities) {
			if (authority.equals(grantedAuthority.getAuthority())) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		return "UsuarioSS [id=" + id + ", email=" + email + ", senha=" + senha + ", authorities=" + authorities + "]";
	}

}
