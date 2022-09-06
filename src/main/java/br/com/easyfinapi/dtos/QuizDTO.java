package br.com.easyfinapi.dtos;

public class QuizDTO {

	private String title;
	private boolean isActive;

	public QuizDTO() {
	}

	public QuizDTO(String title, boolean isActive) {
		this.title = title;
		this.isActive = isActive;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String titulo) {
		this.title = titulo;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
