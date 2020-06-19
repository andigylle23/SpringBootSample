package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	private final EmployeeRepo employeeRepo;
	
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	public void getEmployee() {
		employeeRepo.count();
	}

}
