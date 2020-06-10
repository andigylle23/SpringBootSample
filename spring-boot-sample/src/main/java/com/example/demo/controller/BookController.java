package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.Books;
import com.example.demo.service.BookService;

import java.util.List;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	private List<Books> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@GetMapping("/books/{id}")
	private Books getBook(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}
	
	@DeleteMapping("/books/{id}")
	private void deleteBook(@PathVariable("id") int id) {
		bookService.deleteBook(id);
	}
	
	@PostMapping("/books")
	private int saveBook(@RequestBody Books book) {
		bookService.saveOrUpdate(book);
		
		return book.getId();
	}

}
