package com.reportes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.reportes"})
public class ReportesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportesApplication.class, args);
	}

}
