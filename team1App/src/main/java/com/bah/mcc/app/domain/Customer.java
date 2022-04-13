package com.bah.mcc.app.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMERS")
public class Customer {
	

	//
	//  Make a concrete implementation of a customer domain.  What attributes do you need for
	//  Customer?  At the least, you need to be able to uniquely identify instances of Customer.
	//  Customers have user names, passwords, and email addresses - how would you implement that? 
	//  You may find your implementation changes over time; a simple in-memory implementation 
	//  may be replaced by a robust implementation that makes use of a relational database
	//  as its persistent store, or you may choose some other mechanism.  In thinking about 
	//  how you implement the custome domain, what do you think about to make it easier and 
	//  safer to move from one represenstation to another.	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	
	@Column(name="CUSTOMER_NAME")
	String name;
	
	String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
