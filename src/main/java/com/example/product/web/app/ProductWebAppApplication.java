package com.example.product.web.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//this component scan is needed to autowire and
//load everyything from the server-side
//kleancierge app
@ComponentScan("com.kleancierge.product.api")
//this component scan is needed because the above
//component scan apparently makes the springbootapp
//annotation not load the controllers and other
//items in this web-app
@ComponentScan
public class ProductWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductWebAppApplication.class, args);
    }
}
