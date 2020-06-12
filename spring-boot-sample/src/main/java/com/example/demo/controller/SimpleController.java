package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Books;
import com.example.demo.service.BookRepository;


// Just as the name suggest, it's an annotation for controller.
@Controller
public class SimpleController {

	private final BookRepository bookRepository;
	
	public SimpleController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@GetMapping("/")
	public  String homeDisplay(Model model) {
		model.addAttribute("book", bookRepository.findAll());
		return "index";
	}
	
	@GetMapping("/delete/{title}")
	private String deleteBook(@PathVariable("title") String title) throws ResourceNotFoundException {
		
		Books book = bookRepository.findByTitle(title);
		
		if(book == null) {
			throw new ResourceNotFoundException("No such title found. Please check and try again.");
		} 

		int bookId = book.getId();
		bookRepository.deleteById(bookId);
		
		return "redirect:/";
	}
}
