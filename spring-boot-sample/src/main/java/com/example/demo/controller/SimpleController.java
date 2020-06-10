package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


// Just as the name suggest, it's an annotation for controller.
@Controller
public class SimpleController {

	
	@GetMapping("/")
	public  String homeDisplay() {		
		return "home";
	}
}
