package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String employeeId;
	private String firstName;
	private String lastName;
	private String department;
	private String currentWorkLocation;
	private String currentProject;
	private Date dateCreated;
	private Date dateUpdated;
	
	// getters
	public int getId() {
		return id;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public String getCurrentWorkLocation() {
		return currentWorkLocation;
	}
	
	public String getCurrentProject() {
		return currentProject;
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
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void setCurrentWorkLocation(String currentWorkLocation) {
		this.currentWorkLocation = currentWorkLocation;
	}
	
	public void setCurrentProject(String currentProject) {
		this.currentProject = currentProject;
	}
	
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	

}
