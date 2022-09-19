package br.com.easyfinapi.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.easyfinapi.domains.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
