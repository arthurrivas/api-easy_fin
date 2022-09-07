package br.com.easyfinapi.domains;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ClassRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected Integer id;

	protected String name;
	protected Date startDate;
	
	@ManyToOne(fetch = FetchType.EAGER,  cascade=CascadeType.ALL)
	protected User manager;


	public ClassRoom() {
	}

	public ClassRoom(Integer id, User manager, Date startDate) {
		this.id = id;
		this.manager = manager;
		this.startDate = startDate;
	}
	
	public ClassRoom(Integer id, User manager) {
		this.id = id;
		this.manager = manager;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	
}
