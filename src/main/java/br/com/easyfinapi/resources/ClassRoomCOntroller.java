package br.com.easyfinapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easyfinapi.services.ClassRoomService;
import br.com.easyfinapi.services.ManagerService;

@RestController
@RequestMapping(value = "/class-room")
public class ClassRoomCOntroller {
	
	@Autowired
	ClassRoomService turmaService;
	@Autowired
	ManagerService managerService;

	
	
}











