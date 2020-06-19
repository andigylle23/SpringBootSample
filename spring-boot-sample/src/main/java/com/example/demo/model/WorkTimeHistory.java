package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WorkTimeHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int id;
	private String employeeId;
	private Date clockedIn;
	private Date clockedOut;
	private Date dateCreated;
	private Date dateUpdated;
	
	// Getters
	public int getId() {
		return id;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	
	public Date getClockedIn() {
		return clockedIn;
	}
	
	public Date getClockedOut() {
		return clockedOut;
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
	
	public void setClockedIn(Date clockedIn) {
		this.clockedIn = clockedIn;
	}
	
	public void setClockedOut(Date clockedOut) {
		this.clockedOut = clockedOut;
	}
	
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
}
