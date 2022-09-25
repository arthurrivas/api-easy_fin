package br.com.easyfinapi.domains;

import javax.persistence.Entity;

@Entity
public class Quiz extends CourseStage{
	
	public Quiz() {
	}
	
	public Quiz(Integer id, String title, String description) {
		super(id, title, description);
	}

}
