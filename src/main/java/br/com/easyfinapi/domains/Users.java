package br.com.easyfinapi.domains;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.easyfinapi.domains.enums.Perfil;


public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String nome;
	private String email;
	
	@JsonIgnore
	private String senha;
	
	private Set<Integer> perfisUser = new HashSet<>();
	
	
	public Users() {
	}
	
	
	public Users(String id,String nome, String email,String senha, Perfil perfil) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		addPerfil(perfil);
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Set<Perfil> getPerfisUser() {
		
		return perfisUser.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}


	public void addPerfil(Perfil perfil) {
		perfisUser.add(perfil.getCodPerfil());
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(id, other.id);
	}


	
	
	
}
