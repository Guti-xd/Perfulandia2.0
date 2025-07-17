package com.vendedores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.vendedores"})
public class VendedoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendedoresApplication.class, args);
	}

}
