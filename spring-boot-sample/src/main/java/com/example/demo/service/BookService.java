package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.stereotype.Service;

import com.example.demo.model.BookRepository;
import com.example.demo.model.Books;

import java.util.List;

@Service
public class BookService {
	
	private BookRepository bookRepository;
	
	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	
	public List<Books> getAllBooks(){
		List<Books> bookList = new ArrayList<Books>();
		bookRepository.findAll().forEach(book -> bookList.add(book));
		
		return bookList;
	}
	

	public Books getBookById(int id) {
		return bookRepository.findById(id).get();
	}
	

	public void saveOrUpdate(Books book) {
		bookRepository.save(book);
	}
	

	public void deleteBook(int id) {
		bookRepository.deleteById(id);
	}

}
