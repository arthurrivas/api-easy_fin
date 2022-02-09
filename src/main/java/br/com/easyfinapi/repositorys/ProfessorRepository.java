package br.com.easyfinapi.repositorys;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.easyfinapi.domains.Professor;

@Repository
public interface ProfessorRepository extends MongoRepository<Professor, String> {
	
	
	public Professor findByEmail(String email);
}
