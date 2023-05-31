package com.bke.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Component;

import com.bke.app.model.Employee;
import com.bke.app.repository.EmployeeRepository;

@SpringBootApplication
public class BkeAppBackendApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BkeAppBackendApplication.class, args);
	} 
	
	@Autowired
	private EmployeeRepository empRepository;

//	@Override
//	public void run(String... args) throws Exception {
//		this.empRepository.save(new Employee(1, "sirine", "bke", "16091996"));
//		this.empRepository.save(new Employee(2, "tessnim", "aloui", "02052023"));
//		this.empRepository.save(new Employee(3, "ezzdinee", "aloui", "0911994"));
//	}




}
