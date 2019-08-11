package com.hitesh.emp.empcreation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.hitesh.emp.empcreation.database.EmployeeInfo;
import com.hitesh.emp.empcreation.repository.EmployeeDataRepository;

@EnableJpaAuditing
@SpringBootApplication(scanBasePackages={"com.hitesh.emp.empcreation.*"})
public class EmpcreationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpcreationApplication.class, args);
	}

	
	
}
