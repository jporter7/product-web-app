package com.example.product.web.app.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductCreateController {
        public ProductCreateController() { }

        @GetMapping(value = "/product/create", produces = "text/html")
        public String create(){
            return "forward:/productCreate.html";
        }
}
