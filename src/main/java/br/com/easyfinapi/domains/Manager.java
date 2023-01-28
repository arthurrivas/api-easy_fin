package br.com.easyfinapi.domains;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.easyfinapi.domains.enums.Perfil;

@Entity
@PrimaryKeyJoinColumn(name="idManager")
public class Manager extends User {
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "manager")
	private List<Course> courses = new ArrayList<>();
	
	public Manager() {
	}

	public Manager(Integer id, String name, String email, String phone, String password, Perfil perfil) {
		super(id, name, email,phone, password, perfil);
		
	}

	public void addCourse(Course course){
		this.courses.add(course);
	}
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Manager [getName()=" + getName() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword()
				+ ", getPerfis()=" + getPerfis() + "]";
	}

	
	
	
	
}
