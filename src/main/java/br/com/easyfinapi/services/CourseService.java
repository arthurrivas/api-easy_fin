package br.com.easyfinapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easyfinapi.domains.Course;
import br.com.easyfinapi.domains.Manager;
import br.com.easyfinapi.domains.DTO.CourseDTO;
import br.com.easyfinapi.repositorys.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	public Course save(Course course) {
		
		courseRepository.save(course);
		return course;
	}
	
	
	public Course fromDTO(CourseDTO courseDTO, Manager manager) {
		return new Course(null, courseDTO.getTitle(), courseDTO.getDescription(), manager);
	}
	
}
