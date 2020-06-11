package com.example.demo.apicontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Books;
import com.example.demo.service.BookService;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/books")
public class BookController {
	
	private BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	private List<Books> getAllBooks() {
		return bookService.getAllBooks() ;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	private Books getBook(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	private ResponseEntity<String> deleteBook(@PathVariable("id") int id) {
		bookService.deleteBook(id);
		
		return new ResponseEntity<>("Successfully deleted a book", HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	private ResponseEntity<String> saveBook(@RequestBody Books book) {
		bookService.saveOrUpdate(book);
		
		return new ResponseEntity<>("Successfully register a book", HttpStatus.OK);
	}

}
