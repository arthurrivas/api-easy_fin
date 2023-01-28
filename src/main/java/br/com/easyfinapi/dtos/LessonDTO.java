package br.com.easyfinapi.dtos;

public class LessonDTO {

	private String title;
	private String description;
	private String videoURL;
	
	public LessonDTO() {
	}
	
	public LessonDTO(String title, String description, String videoURL) {
		this.title = title;
		this.description = description;
		this.videoURL = videoURL;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVideoURL() {
		return videoURL;
	}

	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}
}
