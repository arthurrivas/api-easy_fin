package br.com.easyfinapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.easyfinapi.domains.City;
import br.com.easyfinapi.domains.State;
import br.com.easyfinapi.dtos.CityDTO;
import br.com.easyfinapi.services.CityService;
import br.com.easyfinapi.services.StateService;

import java.util.List;

@RestController
@RequestMapping(value = "city")
public class CityController {

    private final String page = "page";
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

    @GetMapping
    public ResponseEntity<?> getCities(@RequestParam(name = "name") String name,
                                       @RequestParam(value= "page", defaultValue="0") Integer page,
                                       @RequestParam(value="linesPerPage", defaultValue="30") Integer linesPerPage,
                                       @RequestParam(value="orderBy", defaultValue="name") String orderBy,
                                       @RequestParam(value="direction", defaultValue="DESC") String direction){

        Page<City> cities = cityService.getCityByFilter(name, page, linesPerPage, direction, orderBy);

        return new ResponseEntity(cities, HttpStatus.OK);
    }
}
