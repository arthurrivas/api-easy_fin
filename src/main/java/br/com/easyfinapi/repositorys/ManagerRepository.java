package br.com.easyfinapi.repositorys;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.easyfinapi.domains.Manager;
import br.com.easyfinapi.domains.User;

@Repository
public interface ManagerRepository extends UserRepository {
	
	public Optional<User> findById(Integer id);
	
	public Manager findByEmail(String email);
}
