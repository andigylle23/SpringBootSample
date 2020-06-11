package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Books {
	
	@Id
	@GeneratedValue
	private int id;
	private String code;
	private String title;
	
	
	// getters
	public int getId() {
		return id;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getTitle() {
		return title;
	}
	
	// setters
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setBookTitle(String title) {
		this.title = title;
	}
	
	public Books(String code, String title) {
		this.code = code;
		this.title = title;
	}
}
