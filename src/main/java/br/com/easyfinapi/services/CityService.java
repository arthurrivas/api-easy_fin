package br.com.easyfinapi.services;

import br.com.easyfinapi.domains.City;
import br.com.easyfinapi.domains.State;
import br.com.easyfinapi.dtos.CityDTO;
import br.com.easyfinapi.repositorys.CityRepository;
import br.com.easyfinapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public City findById(Integer id) {
        Optional<City> city = cityRepository.findById(id);

        if (city.isEmpty())
            throw new ObjectNotFoundException("Cidade nao encontrada");

        return city.get();

    }

    public void save(City city){
        cityRepository.save(city);
    }

    public Page<City> getCityByFilter(String name, Integer page, Integer linesPerPage, String direction, String orderBy ){


        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        return cityRepository.findByNameContainingIgnoreCase(name, pageRequest);
    }

    public City fromDTO(CityDTO objDTO, State state) {
        return new City(objDTO.getId(), objDTO.getName(), state);
    }

}
