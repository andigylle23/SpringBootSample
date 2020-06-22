package com.example.demo.service;

import java.util.Date;
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
	
	
	public String loginUser(String username, String password) throws NotFoundException {
		Employee newEmployee = employeeRepo.findByUsername(username);
		String employee_id = null;
		
		if(newEmployee == null) {
			throw new NotFoundException("justttt");
		} else if(!newEmployee.getPassword().contentEquals(password)) {
			employee_id = "wrong";
		} else if(newEmployee.getPassword().contentEquals(password)) {
			employee_id = newEmployee.getEmployeeId();
		}
		
		return employee_id;
	}
	
	public String registerEmployee(Employee employee) {
		
		String status = null;
		
		Employee existsEmployeeId = employeeRepo.findByUsername(employee.getUsername());
		
		if( existsEmployeeId != null) {
			status = "exists";
		} else if(existsEmployeeId == null) {
			employee.setDateCreated(new Date());
			employee.setDateUpdated(new Date());
			employeeRepo.save(employee);
			status = "save";
		}
		
		return status;
	}
}
