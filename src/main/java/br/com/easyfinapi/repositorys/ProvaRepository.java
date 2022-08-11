package br.com.easyfinapi.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.easyfinapi.domains.Prova;

@Repository
public interface ProvaRepository extends JpaRepository<Prova, Integer>{

}
