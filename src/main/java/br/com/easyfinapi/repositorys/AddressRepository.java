package br.com.easyfinapi.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.easyfinapi.domains.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
    
}
