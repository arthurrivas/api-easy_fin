package br.com.easyfinapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easyfinapi.domains.State;
import br.com.easyfinapi.dtos.StateDTO;
import br.com.easyfinapi.repositorys.StateRepository;
import br.com.easyfinapi.services.exceptions.ObjNotFoundException;

@Service
public class StateService {
    
    @Autowired
    StateRepository stateRepository;

    public State findById(Integer id){
        State state = stateRepository.getById(id);

        if (state == null) throw new ObjNotFoundException("Estado nao encontrado");

        return state;
    }

    public void save(State state){
        stateRepository.save(state);
    }

    public State fromDTO(StateDTO obj){
        return new State(obj.getId(), obj.getName(), obj.getAcronym());
    }
}
