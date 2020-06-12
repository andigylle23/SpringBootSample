package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Books;


@Repository
public interface BookRepository extends CrudRepository<Books, Integer> {
	Books findByTitle(String title);
	List<Books> findByAuthor(String author);
}
