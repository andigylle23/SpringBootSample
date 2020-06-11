package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.BookRepository;


// Just as the name suggest, it's an annotation for controller.
@Controller
public class SimpleController {

	private BookRepository bookRepository;
	
	public SimpleController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@GetMapping("/")
	public  String homeDisplay(Model model) {
		model.addAttribute("book", bookRepository.findAll());
		return "index";
	}
}
