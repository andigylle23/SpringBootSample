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
	public String loginUser(@ModelAttribute("employee") Employee employee) throws NotFoundException  {
		
		String exists = employeeService.findEmployee(employee.getUsername(), employee.getPassword());
		
		if(exists == null || exists.isEmpty()) {
			return "redirect:/notfound";
		} else if(exists.contains("wrong")) {
			return "redirect:/notfound";
		}
		
		return "redirect:/home";
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
