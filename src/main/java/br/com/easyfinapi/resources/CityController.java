package br.com.easyfinapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easyfinapi.domains.City;
import br.com.easyfinapi.domains.State;
import br.com.easyfinapi.dtos.CityDTO;
import br.com.easyfinapi.services.CityService;
import br.com.easyfinapi.services.StateService;

@RestController
@RequestMapping(value = "city")
public class CityController {
    
    @Autowired
    CityService cityService;

    @Autowired
    StateService stateService;

    @PostMapping
    public ResponseEntity<?> createCity(@RequestBody CityDTO cityDTO){

        State state = stateService.findById(cityDTO.getIdState());

        City city = cityService.fromDTO(cityDTO, state);

        cityService.save(city);

        return ResponseEntity.ok(city);
    }
}
