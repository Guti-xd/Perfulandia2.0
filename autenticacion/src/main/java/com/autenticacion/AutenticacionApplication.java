package com.autenticacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.autenticacion"})
public class AutenticacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutenticacionApplication.class, args);
	}

}
