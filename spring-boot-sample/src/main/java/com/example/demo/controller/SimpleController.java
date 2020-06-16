package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Books;
import com.example.demo.service.BookService;


// For UI purpose
@Controller
public class SimpleController {

	private final BookService bookService;
	
	public SimpleController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/books")
	public  String homeDisplay(Model model,  @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);
		
		Page<Books> bookPage = bookService.findPaginatedPage(PageRequest.of(currentPage - 1, pageSize));
		
		model.addAttribute("book", bookPage);
		
		int totalPages  = bookPage.getTotalPages();
		if(totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
					.boxed()
					.collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		return "index";
	}
	
	@GetMapping("books/delete/{title}")
	private String deleteBook(@PathVariable("title") String title) throws ResourceNotFoundException {
		
		bookService.deleteBookByTitle(title);
		
		return "redirect:/books";
	}
	
	@GetMapping("/")
	private String redirectToBookLink() {
		return "redirect:/books";
	}
	
}
