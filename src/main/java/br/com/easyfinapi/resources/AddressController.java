package br.com.easyfinapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easyfinapi.domains.Address;
import br.com.easyfinapi.domains.City;
import br.com.easyfinapi.domains.State;
import br.com.easyfinapi.domains.User;
import br.com.easyfinapi.dtos.AddressDTO;
import br.com.easyfinapi.security.UsuarioSS;
import br.com.easyfinapi.services.CityService;
import br.com.easyfinapi.services.StateService;
import br.com.easyfinapi.services.UserServices;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    UserServices userService;
    @Autowired
    CityService cityService;
    @Autowired
    StateService stateService;

    @PostMapping("/user/{id}")
    public ResponseEntity<?> createAddress(@PathVariable(name = "id") Integer id, @RequestBody AddressDTO addressDTO){
        
        User user = userService.findById(id);
        City city = cityService.findById(addressDTO.getIdCity());

        Address address = new Address(addressDTO.getId(), addressDTO.getNumber(), city, user);
        
        return ResponseEntity.ok(address);
    }
    
    
}
