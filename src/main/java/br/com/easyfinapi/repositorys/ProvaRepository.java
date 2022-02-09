package br.com.easyfinapi.repositorys;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.easyfinapi.domains.Prova;

@Repository
public interface ProvaRepository extends MongoRepository<Prova, String>{

}
