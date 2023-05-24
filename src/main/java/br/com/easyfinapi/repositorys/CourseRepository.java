package br.com.easyfinapi.repositorys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.easyfinapi.domains.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    public Page<Course> findCourseByManagerId(Integer managerId, Pageable pageable);
}
