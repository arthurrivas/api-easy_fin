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
import br.com.easyfinapi.domains.Lesson;
import br.com.easyfinapi.domains.Manager;
import br.com.easyfinapi.dtos.CourseDTO;
import br.com.easyfinapi.dtos.LessonDTO;
import br.com.easyfinapi.security.UsuarioSS;
import br.com.easyfinapi.services.CourseService;
import br.com.easyfinapi.services.LessonService;
import br.com.easyfinapi.services.ManagerService;
import br.com.easyfinapi.services.UserServices;

@RestController
@RequestMapping(value = "/course")
public class CourseController {

	@Autowired
	CourseService courseService;
	@Autowired
	ManagerService managerService;
	@Autowired
	UserServices userService;
	@Autowired
	LessonService lessonService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getCourseById(@PathVariable(name = "id") Integer id){
		
		Course course = courseService.findById(id);
		
		return new ResponseEntity<>(HttpStatus.OK).ok(course);
		
	}

	@GetMapping(value = "/manager/{id}")
	public ResponseEntity<?> getCourseByManagerId(@PathVariable(name = "id") Integer id) {

		List<Course> course = managerService.findById(id).getCourses();

		return new ResponseEntity(HttpStatus.OK).ok(course);

	}

	@PostMapping()
	public ResponseEntity<?> createCourse(@RequestBody CourseDTO courseDTO) {
		
		UsuarioSS ss = userService.isAuthenticated();
		
		Manager manager = managerService.findById(ss.getId());

		Course course = courseService.fromDTO(courseDTO, manager);
		courseService.save(course);

		return new ResponseEntity(HttpStatus.OK).ok(course);

	}
	
	@PostMapping(value =  "/{id}/lesson")
	public ResponseEntity<?> addLesson(@PathVariable(name = "id") Integer id, @RequestBody LessonDTO lessonDTO ){
		
		Course course = courseService.findById(id);
		Lesson lesson = lessonService.fromDTO(lessonDTO);
		
		lesson.setCourse(course);
		lessonService.save(lesson);

		
		return new ResponseEntity<>(HttpStatus.OK).ok(course);

	}
	
	

}
