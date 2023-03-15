package br.com.easyfinapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easyfinapi.domains.Address;
import br.com.easyfinapi.domains.City;
import br.com.easyfinapi.domains.User;
import br.com.easyfinapi.dtos.AddressDTO;
import br.com.easyfinapi.services.AddressService;
import br.com.easyfinapi.services.CityService;
import br.com.easyfinapi.services.UserServices;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    UserServices userService;
    @Autowired
    CityService cityService;

    @Autowired
    AddressService addressService;

    @PostMapping("/user/{id}")
    public ResponseEntity<?> createAddress(@PathVariable(name = "id") Integer id, @RequestBody AddressDTO addressDTO){
        
        User user = userService.findById(id);
        City city = cityService.findById(addressDTO.getCity().getId());

        Address address = new Address(addressDTO.getId(), addressDTO.getNumber());
        address.setCity(city);

        user.setAddress(address);
        userService.save(user);
        
        return ResponseEntity.ok(address);
    }
    
    
}
