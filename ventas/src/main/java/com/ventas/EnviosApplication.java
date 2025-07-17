package com.ventas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.ventas"})
public class EnviosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnviosApplication.class, args);
	}

}
