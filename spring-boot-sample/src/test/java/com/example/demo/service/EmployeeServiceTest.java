package com.example.demo.service;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;

import javassist.NotFoundException;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@Mock
	private EmployeeRepo employeeRepo;
	
	@InjectMocks
	private EmployeeService employeeService;
	
	
	@Test
	void shouldThrowErrorWhenAlreadyExists() {
		
	}
}
