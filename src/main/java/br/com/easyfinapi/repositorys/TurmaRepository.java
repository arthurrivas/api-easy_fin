package br.com.easyfinapi.repositorys;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.easyfinapi.domains.Turma;

@Repository
public interface TurmaRepository extends MongoRepository<Turma, String> {

	
}
