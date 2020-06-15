package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//This annotation is used to mark a configuration class that declare one or more
// @Bean methods and also triggers auto-configuration and component scanning.
@SpringBootApplication
@EnableJpaRepositories("com.example.demo.repository")
@EntityScan("com..example.demo.model")
public class SpringBootSampleApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSampleApplication.class, args);
	}

}
