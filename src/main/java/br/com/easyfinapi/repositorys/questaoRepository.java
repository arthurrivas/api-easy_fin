package br.com.easyfinapi.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.easyfinapi.domains.Questao;

@Repository
public interface questaoRepository extends JpaRepository<Questao, Integer> {
	
}
