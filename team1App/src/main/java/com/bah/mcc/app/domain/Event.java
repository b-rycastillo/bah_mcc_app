package com.bah.mcc.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//
@Entity
@Table(name="EVENTS")
public class Event {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	
	@Column(name="CODE")
	String code;
	
	@Column(name="TITLE")
	String title;
	
	@Column(name="DESCRIPTION")
	String description;
	
	public Event() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Event(long id, String code, String title, String description) {
		super();
		this.id = id;
		this.code = code;
		this.title = title;
		this.description = description;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
	
	
}
