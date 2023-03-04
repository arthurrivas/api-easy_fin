package br.com.easyfinapi.services;

import br.com.easyfinapi.domains.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easyfinapi.domains.Course;
import br.com.easyfinapi.dtos.CourseDTO;
import br.com.easyfinapi.repositorys.CourseRepository;
import br.com.easyfinapi.services.exceptions.ObjectNotFoundException;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	public Course save(Course course) {
		
		courseRepository.save(course);
		return course;
	}
	
	public Course findById(Integer id) {
		Course course = courseRepository.findById(id).get();
		
		if (course == null) throw new ObjectNotFoundException("Curso não encontrado");
		
		return course;
	}
	
	public Course fromDTO(CourseDTO courseDTO, User manager) {
		return new Course(null, courseDTO.getTitle(), courseDTO.getDescription(), manager);
	}
	
}
