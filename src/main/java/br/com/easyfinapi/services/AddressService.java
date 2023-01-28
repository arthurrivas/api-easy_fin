package br.com.easyfinapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easyfinapi.domains.Address;
import br.com.easyfinapi.domains.City;
import br.com.easyfinapi.dtos.AddressDTO;
import br.com.easyfinapi.repositorys.AddressRepository;

@Service
public class AddressService {
    
    @Autowired
    AddressRepository addressRepository;

    
};
