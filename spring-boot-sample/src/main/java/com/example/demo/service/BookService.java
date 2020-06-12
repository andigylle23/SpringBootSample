package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Books;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public void deleteBookByTitle(String title) throws ResourceNotFoundException {
		
		Books book = bookRepository.findByTitle(title);
		
		if(book == null) {
			throw new ResourceNotFoundException("No such title found. Please check and try again.");
		} 

		int bookId = book.getId();
		bookRepository.deleteById(bookId);
		
	}
	
	public Iterable<Books> findAllRegisteredBooks() {
		return bookRepository.findAll();
		
	}
}
