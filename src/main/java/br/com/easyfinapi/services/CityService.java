package br.com.easyfinapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easyfinapi.domains.City;
import br.com.easyfinapi.domains.State;
import br.com.easyfinapi.repositorys.CityRepository;
import br.com.easyfinapi.services.exceptions.ObjectNotFoundException;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public City findById(Integer id) {
        City city = cityRepository.findById(id).get();

        if (city == null)
            throw new ObjectNotFoundException("Cidade nao encontrada");

        return city;

    }

}
