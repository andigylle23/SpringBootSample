package com.example.demo.repository;


import java.util.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.example.demo.model.Employee;

@DataJpaTest
public class EmployeeRepositoryTest {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@Test
	public void registerEmployeeSuccess() {
		Employee employee = new Employee();
		employee.setEmployeeId("3617");
		employee.setUsername("test-user");
		employee.setPassword("test-pass");
		employee.setEmail("test-user@mail.com");
		employee.setDateCreated(new Date());
		employee.setDateUpdated(new Date());
		
		employeeRepo.save(employee);
		Assertions.assertNotNull(employee.getEmployeeId());
	}
	
	@Test
	public void registerEmployeeFailure() {
		Employee employee = new Employee();
		employee.setUsername("test-user");
		employee.setPassword("test-pass");
		employee.setEmail("test-user@mail.com");
		employee.setDateCreated(new Date());
		employee.setDateUpdated(new Date());
		
		employeeRepo.save(employee);
		Assertions.assertNull(employee.getEmployeeId());
	}

}
