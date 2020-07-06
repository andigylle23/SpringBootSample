package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "Employee Id should not be empty")
	private String employeeId;
	
	@NotBlank
	@Size(min = 4, max = 50)
	private String username;
	
	@NotBlank
	@Size(min = 8, max = 15)
	private String password;
	
	@NotBlank
	@Email(message = "Please enter a valid e-mail address")
	private String email;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss.SSSZ")
	private Date dateCreated;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss.SSSZ")
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
	
	public String getEmail() {
		return email;
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
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
}
