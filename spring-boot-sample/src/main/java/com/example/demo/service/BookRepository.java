package com.example.demo.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Books;


public interface BookRepository extends CrudRepository<Books, String> {
	Books findByTitle(String title);
	List<Books> findByAuthor(String author);
}
