package com.example.demo.service;

import java.util.Date;
import org.springframework.stereotype.Service;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;


@Service
public class EmployeeService {
	
	private final EmployeeRepo employeeRepo;
	
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	public String checkUserNameExist(String username) {
		String status = null;
		
		Employee employee = employeeRepo.findByUsername(username);
		
		if(employee == null) {
			status = "not exists";
		} else {
			status = "exist";
		}
		
		return status;

	}
	
	public String loginUser(String username, String password) {
		
		String status = checkUserNameExist(username);
		String employee_stat = null;
		
		Employee employee = employeeRepo.findByUsername(username);
		
		if(status.contentEquals("not exists")) {
			employee_stat = "not exists";
		} else if(status.contentEquals("exist")) {
			if(employee.getPassword().contentEquals(password)) {
				employee_stat = employee.getEmployeeId();
			} else if(!employee.getPassword().contentEquals(password)) {
				employee_stat = "wrong password";
			}
		} 
		
		return employee_stat;
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
