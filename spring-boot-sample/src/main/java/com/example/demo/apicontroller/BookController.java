package com.example.demo.apicontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Books;
import com.example.demo.service.BookService;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/books")
public class BookController {
	
	private BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	private List<Books> getAllBooks() {
		
		if(bookService.getAllBooks() == null) {
			
		}
		return bookService.getAllBooks();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	private Books getBook(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	private void deleteBook(@PathVariable("id") int id) {
		bookService.deleteBook(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	private int saveBook(@RequestBody Books book) {
		bookService.saveOrUpdate(book);
		
		return book.getId();
	}

}
