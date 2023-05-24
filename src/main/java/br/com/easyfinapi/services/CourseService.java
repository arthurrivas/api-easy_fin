package br.com.easyfinapi.services;

import br.com.easyfinapi.domains.User;
import br.com.easyfinapi.domains.enums.Perfil;
import br.com.easyfinapi.security.UsuarioSS;
import br.com.easyfinapi.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	
	public Course fromDTO(CourseDTO courseDTO) {
		return new Course(courseDTO.getId(), courseDTO.getTitle(), courseDTO.getDescription());
	}

    public Page<Course> getCourseByFilter(Integer id, Integer page, Integer linesPerPage, String direction, String orderBy) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

		return courseRepository.findCourseByManagerId(id, pageRequest);
    }

	public boolean ownCourseOrIsAdmin(Integer id, User user){
		if (id != user.getId() || !user.isAdmin()) throw new ForbiddenException("Sem autorizacao de ver cursos de outros cuidadores");

		return true;
	}
}



