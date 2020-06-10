package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Books;
import com.example.demo.dao.BookRepository;

import java.util.List;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
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
