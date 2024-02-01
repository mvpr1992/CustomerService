package com.ucm.customerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CustomerServiceApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CustomerServiceApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
}
