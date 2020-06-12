package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.service.BookService;


// For UI purpose
@Controller
public class SimpleController {

	private final BookService bookService;
	
	public SimpleController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/")
	public  String homeDisplay(Model model) {
		model.addAttribute("book", bookService.findAllRegisteredBooks());
		return "index";
	}
	
	@GetMapping("/delete/{title}")
	private String deleteBook(@PathVariable("title") String title) throws ResourceNotFoundException {
		
		bookService.deleteBookByTitle(title);
		
		return "redirect:/";
	}
}
