package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String employeeId;
	private String username;
	private String password;
	private Date dateCreated;
	private Date dateUpdated;
	
	// Getters
	public int getId() {
		return id;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}

	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public Date getDateUpdated() {
		return dateUpdated;
	}
	
	
	// Setters
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
}
