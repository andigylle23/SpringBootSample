package com.example.demo.apicontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import javassist.NotFoundException;

@Controller
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping("/login")
	public String loginUser(@ModelAttribute("employee") Employee employee) {
		
		String status = employeeService.loginUser(employee.getUsername(), employee.getPassword());
		String redirect = null;
		
		if(status.contentEquals("not exists") || status.contentEquals("wrong password")) {
			redirect = "redirect:/";
		} else {
			redirect = "redirect:/home";
		}
		return redirect;
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("employee") Employee employee) {
		String status = employeeService.registerEmployee(employee);
		
		if(status == "exists") {
			return "redirect:/notfound";
		}
		
		return "redirect:/";
	}
}
