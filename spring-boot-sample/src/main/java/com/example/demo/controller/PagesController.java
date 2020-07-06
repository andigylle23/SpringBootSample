package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import javassist.NotFoundException;
import javassist.expr.NewArray;

@Controller
public class PagesController {
	
	// Mapping the mode of the book
	@GetMapping("/")
	public String goToRegisterPage(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "login";
	}
	
	@GetMapping("/register")
	public String goToRegistrationPage(Model model) {
		model.addAttribute("employee", new Employee());
		return "registration";
	}
	
	@GetMapping("/home")
	public String goToHomePagePage() {
		return "home";
	}
	
	@GetMapping("/notfound")
	public String goToNotFound() {
		return "error";
	}
}
