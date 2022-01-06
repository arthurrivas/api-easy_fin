package br.com.easyfinapi.repositorys;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.easyfinapi.domains.Users;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {

}
