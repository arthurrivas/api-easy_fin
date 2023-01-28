package br.com.easyfinapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easyfinapi.domains.Lesson;
import br.com.easyfinapi.dtos.LessonDTO;
import br.com.easyfinapi.repositorys.LessonRepository;

@Service
public class LessonService {

	@Autowired
	LessonRepository lessonRepository;
	
	public Lesson fromDTO(LessonDTO lessonDTO) {
		
		return new Lesson(null, lessonDTO.getTitle(), lessonDTO.getDescription(), lessonDTO.getVideoURL());		
	}

	public void save(Lesson lesson) {
		lessonRepository.save(lesson);
	}
}
