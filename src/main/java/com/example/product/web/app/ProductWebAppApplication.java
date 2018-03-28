package com.example.product.web.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.kleancierge.product.api")
public class ProductWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductWebAppApplication.class, args);
	}
}
