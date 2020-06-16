package com.example.demo.service;

import java.util.Collections;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
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
	
	public List<Books> findAllRegisteredBooks() {
		return bookRepository.findAll();
		
	}
	
	
	public Page<Books> findPaginatedPage(Pageable pageable) {
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<Books> bookList;
		List<Books> books = findAllRegisteredBooks();
		
		if(books.size() < startItem) {
			bookList = Collections.emptyList();
		} else {
			int toIndex = (int) Math.min(startItem + pageSize, books.size());
			bookList = books.subList(startItem, toIndex);
		}
		
		Page<Books> bookPage = new PageImpl<Books>(bookList, PageRequest.of(currentPage, pageSize), books.size());
		
		return bookPage;
		
	}
}
