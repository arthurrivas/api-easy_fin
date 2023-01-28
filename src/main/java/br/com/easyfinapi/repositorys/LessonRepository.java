package br.com.easyfinapi.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easyfinapi.domains.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {

}
