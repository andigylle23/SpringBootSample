package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//This annotation is used to mark a configuration class that declare one or more
// @Bean methods and also triggers auto-configuration and component scanning.
@SpringBootApplication
public class SpringBootSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSampleApplication.class, args);
	}

}
