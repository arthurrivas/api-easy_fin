package br.com.easyfinapi.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.easyfinapi.domains.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    
}
