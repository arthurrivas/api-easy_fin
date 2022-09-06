package br.com.easyfinapi.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.easyfinapi.domains.Quiz;
import br.com.easyfinapi.dtos.QuizDTO;
import br.com.easyfinapi.repositorys.QuizRepository;

@Service
public class QuizService {

	
	@Autowired
	QuizRepository quizRepository;

	
	public void save(Quiz quiz) {
		quizRepository.save(quiz);
	}
	
	public void saveAll(Quiz prova) {
		quizRepository.saveAll(Arrays.asList(prova));
	}
	
	public Quiz findById(Integer id) {
		return quizRepository.findById(id).get();
	}
	
	
	public Quiz fromDTO(QuizDTO quizDTO , Integer idManager){
		return new Quiz(null , quizDTO.getTitle(), idManager);
	}

	public void update(Quiz quiz, QuizDTO quizDTO) {
		
		quiz.setTitle(quizDTO.getTitle());
		quiz.setActive(quizDTO.isActive());
		
		this.save(quiz);
		
	}
	
}
