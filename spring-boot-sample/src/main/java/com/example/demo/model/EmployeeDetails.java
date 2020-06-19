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
	private String employee_id;
	private String first_name;
	private String last_name;
	private String department;
	private String current_work_location;
	private String current_project;
	private Date date_created;
	private Date date_updated;
	
	// getters
	public int getId() {
		return id;
	}
	
	public String getEmployee_id() {
		return employee_id;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public String getCurrent_work_location() {
		return current_work_location;
	}
	
	public String getCurrent_project() {
		return current_project;
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
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void setCurrent_work_location(String current_work_location) {
		this.current_work_location = current_work_location;
	}
	
	public void setCurrent_project(String current_project) {
		this.current_project = current_project;
	}
	
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	
	public void setDate_updated(Date date_Updated) {
		this.date_updated = date_Updated;
	}
	

}
