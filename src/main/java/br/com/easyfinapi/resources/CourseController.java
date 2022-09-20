package br.com.easyfinapi.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easyfinapi.domains.Course;
import br.com.easyfinapi.domains.Manager;
import br.com.easyfinapi.domains.DTO.CourseDTO;
import br.com.easyfinapi.services.CourseService;
import br.com.easyfinapi.services.ManagerService;

@RestController
@RequestMapping(value = "/course")
public class CourseController {

	@Autowired
	CourseService courseService;
	@Autowired
	ManagerService managerService;
	
	@GetMapping(value = "/manager/{id}")
	public ResponseEntity<?> getCourseByManagerId(@PathVariable(name = "id") Integer id){
		try {
			
			List<Course> course = managerService.findById(id).getCourses();
			
			return new ResponseEntity(HttpStatus.OK).ok(course);
			
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	@PostMapping(value = "/manager/{id}")
	public ResponseEntity<?> createCourse(@PathVariable(name = "id") Integer id, @RequestBody CourseDTO courseDTO ){
		try {
			
			Manager manager = managerService.findById(id);
			
			System.out.println(manager);
			
			if(manager.getId() != null) {
				Course course = courseService.fromDTO(courseDTO, manager);
				
				courseService.save(course);
				
				return new ResponseEntity(HttpStatus.OK).ok(course);
			}
			
			return new ResponseEntity(HttpStatus.BAD_REQUEST).badRequest().build();
			
			
			
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
		
		
		
	}
	
}
