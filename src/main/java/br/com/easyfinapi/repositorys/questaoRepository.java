package br.com.easyfinapi.repositorys;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.easyfinapi.domains.Questao;

@Repository
public interface questaoRepository extends MongoRepository<Questao, String> {
	
}
