package br.com.easyfinapi.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.easyfinapi.domains.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer>{

}
