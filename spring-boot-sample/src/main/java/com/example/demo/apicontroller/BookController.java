package com.example.demo.apicontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Books;
import com.example.demo.repository.BookRepository;

import java.util.List;

// Just for an example of postman
@RestController
@RequestMapping("/v1/api/book")
public class BookController {
	
	private final BookRepository bookRepository;
	
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@GetMapping
	private Iterable<Books> getAllBooks() throws ResourceNotFoundException {
		
		Iterable<Books> bookList = bookRepository.findAll();
		
		if(bookList == null) {
			throw new ResourceNotFoundException("No registered books yet.");
		}
		
		return bookList;
	}
	
	@GetMapping("/title/{title}")
	private Books getBook(@PathVariable("title") String  title) throws ResourceNotFoundException {	
		
		Books book = bookRepository.findByTitle(title);
		
		if(book == null) {
			throw new ResourceNotFoundException("No book found with that book title");
		}  
		
		return book;
	}
	
	@GetMapping("/author/{author}")
	private List<Books> getAuthor(@PathVariable("author") String author) throws ResourceNotFoundException {
		List<Books> bookList = bookRepository.findByAuthor(author);
		
		if(bookList == null || bookList.isEmpty()) {
			throw new ResourceNotFoundException("No book found with that author name");
		}
		
		return bookList;
	}
	
	
	@PostMapping
	private Books registerBook(@RequestBody Books book) throws ResourceNotFoundException {
		
		Books books = bookRepository.findByTitle(book.getTitle());
		
		if(books != null) {
			throw new ResourceNotFoundException("The same book title already exists ");
		} 
		
		
		return  bookRepository.save(book);
	}
	
	
	@GetMapping("/delete/{title}")
	private void deleteBook(@PathVariable("title") String title) throws ResourceNotFoundException {
		
		Books book = bookRepository.findByTitle(title);
		
		if(book == null) {
			throw new ResourceNotFoundException("No such title found. Please check and try again.");
		} 
		
		int bookId = book.getId();
		bookRepository.deleteById(bookId);
	}
	
}
