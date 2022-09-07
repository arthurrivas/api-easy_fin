package br.com.easyfinapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easyfinapi.domains.ClassRoom;
import br.com.easyfinapi.repositorys.ClassRoomRepository;

@Service
public class ClassRoomService {
	
	
	@Autowired
	ClassRoomRepository classRoomRepository;
	
	public List<ClassRoom> retornaTurmas(){		
		return classRoomRepository.findAll();
	}
	
	public ClassRoom findById(Integer id) {
		return classRoomRepository.findById(id).get();
	}
	
	public void saveClassRoom(ClassRoom classRoom) {
		classRoomRepository.save(classRoom);
	}
	
}
