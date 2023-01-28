package br.com.easyfinapi.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.easyfinapi.domains.State;

@Repository
public interface StateRepository extends JpaRepository<State,Integer> {
    
}
