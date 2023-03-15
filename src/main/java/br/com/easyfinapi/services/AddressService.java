package br.com.easyfinapi.services;

import br.com.easyfinapi.dtos.AddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easyfinapi.domains.Address;
import br.com.easyfinapi.repositorys.AddressRepository;

@Service
public class AddressService {
    
    @Autowired
    AddressRepository addressRepository;

    public void save(Address address){
        addressRepository.save(address);
    }

    public Address fromDTO(AddressDTO address) {
        return new Address(address.getId(), address.getNumber());
    }
};
