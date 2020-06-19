package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import javassist.NotFoundException;
import javassist.expr.NewArray;

@Controller
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	// Mapping the mode of the book
	@GetMapping("/")
	public String goToRegisterPage(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		
		return "register";
	}
	
	@GetMapping("/home")
	public String goToHomePagePage() {
		return "index";
	}
	@GetMapping("/notfound")
	public String goToNotFound() {
		return "error";
	}
	
	@PostMapping("/login")
	public String loginUser(@ModelAttribute("employee") Employee employee) throws NotFoundException  {
		
		String exists = employeeService.findEmployee(employee.getUsername(), employee.getPassword());
		
		if(exists == null || exists.isEmpty()) {
			return "redirect:/notfound";
		} else if(exists.contains("wrong")) {
			return "redirect:/notfound";
		}
		
		return "redirect:/home";
	}
}
