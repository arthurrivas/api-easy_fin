package br.com.easyfinapi.domains;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Quiz extends CourseStage{
	
	
	@OneToMany(mappedBy = "quiz")
	private List<Question> question = new ArrayList<>();

	public Quiz() {
	}
	
	public Quiz(Integer id, String title, String description) {
		super(id, title, description);
	}

	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}
	
	public void addQuestion(Question question) {
		this.question.add(question);
	}
}
