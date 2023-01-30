package br.com.easyfinapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easyfinapi.domains.State;
import br.com.easyfinapi.dtos.StateDTO;
import br.com.easyfinapi.services.StateService;

@RestController
@RequestMapping(value = "/state")
public class StateController {
    
    @Autowired
    StateService stateService;


    @PostMapping
    public ResponseEntity<?> createState(@RequestBody StateDTO stateDTO){

        State state = stateService.fromDTO(stateDTO);

        stateService.save(state);

        return ResponseEntity.ok(state);

    }
}
