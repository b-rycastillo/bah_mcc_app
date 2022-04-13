package com.bah.mcc.app.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REGISTRATIONS")
public class Registration {
	//  Workshop:
	//
	//  Implement Registration.  Your implementation is very likely going to change 
	//  over time as you add functionality 
	//return null;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	
	@Column(name="EVENT_ID")
	String event_id;
	
	@Column(name="CUSTOMER_ID")
	String customer_id;
	
	Date registration_date;
	
	String notes;
	public long getId() {
		return id;
	}
	public String getEvent_id() {
		return event_id;
	}
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public Date getRegistration_date() {
		return registration_date;
	}
	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
}
