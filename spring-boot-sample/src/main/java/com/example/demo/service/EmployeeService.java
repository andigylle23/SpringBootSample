package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;
import javassist.NotFoundException;


@Service
public class EmployeeService {
	
	private final EmployeeRepo employeeRepo;
	
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	
	public String findEmployee(String username, String password) throws NotFoundException {
		Employee newEmployee = employeeRepo.findByUsername(username);
		String employee_id = null;
		
		if(newEmployee == null) {
			throw new NotFoundException("justttt");
		} else if(!newEmployee.getPassword().contentEquals(password)) {
			employee_id = "wrong";
		} else if(newEmployee.getPassword().contentEquals(password)) {
			employee_id = newEmployee.getEmployee_id();
		}
		
		return employee_id;
	}
}
