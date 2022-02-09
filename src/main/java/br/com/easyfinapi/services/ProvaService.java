package br.com.easyfinapi.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easyfinapi.domains.Prova;
import br.com.easyfinapi.dtos.ProvaDTO;
import br.com.easyfinapi.repositorys.ProvaRepository;

@Service
public class ProvaService {

	
	@Autowired
	ProvaRepository provaRepository;

	
	public void saveAll(Prova prova) {
		provaRepository.saveAll(Arrays.asList(prova));
	}
	
	
	public Prova fromDTO(ProvaDTO provaDTO){
		return new Prova(null,provaDTO.getTitulo(),null);
	}
	
}
