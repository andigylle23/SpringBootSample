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
	private String employee_id;
	private Date clocked_in;
	private Date clocked_out;
	private Date date_created;
	private Date date_updated;
	
	// Getters
	public int getId() {
		return id;
	}
	
	public String getEmployee_id() {
		return employee_id;
	}
	
	public Date getClocked_in() {
		return clocked_in;
	}
	
	public Date getClocked_out() {
		return clocked_out;
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
	
	public void setClocked_in(Date clocked_in) {
		this.clocked_in = clocked_in;
	}
	
	public void setClocked_out(Date clocked_out) {
		this.clocked_out = clocked_out;
	}
	
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	
	public void setDate_updated(Date date_updated) {
		this.date_updated = date_updated;
	}
}
