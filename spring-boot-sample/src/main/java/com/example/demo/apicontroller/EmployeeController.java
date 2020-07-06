package com.example.demo.apicontroller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.controller.PagesController;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	private EmployeeService employeeService;
	
	PagesController pagesController = new PagesController();
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);


	@PostMapping("/login")
	public RedirectView loginUser(@ModelAttribute("employee") Employee employee) {
		
		String status = employeeService.loginUser(employee.getUsername(), employee.getPassword());
		String redirect = null;
		
		if(status.contentEquals("not exists") || status.contentEquals("wrong password")) {
//			redirect = "redirect:/";
		} else {
//			return "redirect:/home"
		}
//		return redirect;
		return null;
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model) {
		model.addAttribute("employee", employee);
		String status = employeeService.registerEmployee(employee);
		String redirect = "";
		

    if (bindingResult.hasErrors()) { 
			log.debug( "thissssssssssss: " + employee );
         redirect = "redirect:/register";
////	    } else if(status == "exists") {
////	    	redirect = "redirect:/notfound";
	    } else {
	    	return redirect;
	    }
		
		
		return redirect;
	}
}
