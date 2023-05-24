package br.com.easyfinapi.resources;

import java.util.List;

import br.com.easyfinapi.domains.City;
import br.com.easyfinapi.domains.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.easyfinapi.domains.Course;
import br.com.easyfinapi.domains.Lesson;
import br.com.easyfinapi.dtos.CourseDTO;
import br.com.easyfinapi.dtos.LessonDTO;
import br.com.easyfinapi.security.UsuarioSS;
import br.com.easyfinapi.services.CourseService;
import br.com.easyfinapi.services.LessonService;
import br.com.easyfinapi.services.ManagerService;
import br.com.easyfinapi.services.UserServices;
import org.springframework.web.server.MethodNotAllowedException;

@RestController
@RequestMapping(value = "/course")
public class CourseController {


	@Autowired
	private CourseService courseService;
	@Autowired
	private UserServices userService;

	//	GET COURSES CREATED BY LOGGED MANAGER
	@PostMapping
	public ResponseEntity<?> createCourse(@RequestBody CourseDTO courseDTO){

		UsuarioSS ss = userService.isAuthenticated();

		User user = userService.findById(ss.getId());

		Course course = courseService.fromDTO(courseDTO);
		course.setManager(user);

		courseService.save(course);

		return new ResponseEntity(course, HttpStatus.CREATED);

	}


//	GET COURSES CREATED BY MANAGER_ID
	@GetMapping(value = "/manager/{id}")
	public ResponseEntity<Page<Course>> getManagerCourses(
			@PathVariable(name ="id") Integer id,
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue="10") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue="title") String orderBy,
			@RequestParam(value="direction", defaultValue="DESC") String direction){

		UsuarioSS ss = userService.isAuthenticated();
		User user = userService.findById(ss.getId());

		courseService.ownCourseOrIsAdmin(id, user);

		Page<Course> courses = courseService.getCourseByFilter(ss.getId(), page, linesPerPage, direction, orderBy);

		return new ResponseEntity(courses, HttpStatus.OK);

	}

}
