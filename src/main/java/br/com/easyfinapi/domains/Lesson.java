package br.com.easyfinapi.domains;

import javax.persistence.Entity;

@Entity
public class Lesson extends CourseStage {

	private String videoURL;

	public Lesson() {
	}
	
	public Lesson(Integer id, String title, String description ,String videoURL) {
		super(id, title, description);
		this.videoURL = videoURL;
	}

	public String getVideoURL() {
		return videoURL;
	}

	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}
	
}
