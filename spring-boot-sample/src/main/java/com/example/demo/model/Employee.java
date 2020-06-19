package com.example.demo.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String employee_id;
	private String username;
	private String password;
	private Date date_created;
	private Date date_updated;
	
	// Getters
	public int getId() {
		return id;
	}
	
	public String getEmployee_id() {
		return employee_id;
	}

	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Date getDate_created() {
		return date_created;
	}
	
	public Date getDate_updated() {
		return date_updated;
	}
	
	
	// Setters
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	
	public void setDate_updated(Date date_updated) {
		this.date_updated = date_updated;
	}
}
