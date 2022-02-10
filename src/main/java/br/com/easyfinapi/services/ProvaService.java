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
	
	public Prova findById(String id) {
		return provaRepository.findById(id).get();
	}
	
	
	public Prova fromDTO(ProvaDTO provaDTO , String idProfessor){
		return new Prova(null,provaDTO.getTitulo(),null, idProfessor);
	}
	
}
