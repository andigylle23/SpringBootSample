package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// データベーステーブルにマップする
@Entity
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String barcode;
	private String title;
	private String author;
	private Date date_created;
	private Date date_updated;

	// ゲッター
	public int getId() {
		return id;
	}
	
	public String getBarcode() {
		return barcode;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
	
	public Date getDate_created() {
		return date_created;
	}
	
	public Date getDate_updated() {
		return date_updated;
	}

	// セーター
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	
	public void setDate_updated(Date date_updated) {
		this.date_updated = date_updated;
	}

}
