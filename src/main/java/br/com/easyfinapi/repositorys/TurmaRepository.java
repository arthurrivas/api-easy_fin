package br.com.easyfinapi.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.easyfinapi.domains.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

	
}
