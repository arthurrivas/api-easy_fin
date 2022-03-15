package br.com.easyfinapi.repositorys;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.easyfinapi.domains.Aluno;

@Repository
public interface AlunoRepository extends MongoRepository<Aluno, String>{
	
	public Aluno findByEmail(String email);

}
