package br.com.easyfinapi.domains;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private String title;
	private String description;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "course")
	private List<CourseStage> courseStages = new ArrayList<>();
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="manager_id")
    private User manager;

	@ManyToMany
	@JoinTable(
			name="students_course",
			joinColumns=
				{@JoinColumn(name="course_id")},
			inverseJoinColumns=
				{@JoinColumn(name="user_id")}
	)
	private List<User> students = new ArrayList<>();
	
	public Course() {
	}
	
	public Course(Integer id, String title, String description, User manager) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.manager = manager;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}
	
	public List<CourseStage> getCourseStages() {
		return courseStages;
	}

	public void setCourseStages(List<CourseStage> courseStages) {
		this.courseStages = courseStages;
	}

	public void addCourseStage(CourseStage courseStage) {
		this.courseStages.add(courseStage);
	}	
}
