package com.example.demo.apicontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Books;
import com.example.demo.service.BookRepository;

import java.util.List;

@RestController
@RequestMapping("/v1/api/book")
public class BookController {
	
	private BookRepository bookRepository;
	
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@GetMapping
	private Iterable<Books> getAllBooks() {
		
		return bookRepository.findAll();
	}
	
	@GetMapping("/title/{title}")
	private Books getBook(@PathVariable("title") String  title) {		
		return  bookRepository.findByTitle(title);
	}
	
	@GetMapping("/author/{author}")
	private List<Books> getAuthor(@PathVariable("author") String author) {
		return bookRepository.findByAuthor(author);
	}
	
	
}
