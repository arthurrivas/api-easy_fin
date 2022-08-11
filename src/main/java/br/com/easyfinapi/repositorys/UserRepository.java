package br.com.easyfinapi.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.easyfinapi.domains.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findById(Integer id);

	User findByEmail(String email);

}
