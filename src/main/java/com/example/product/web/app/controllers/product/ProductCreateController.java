package com.example.product.web.app.controllers.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductCreateController {
        public ProductCreateController() { }

        @GetMapping(value = "/vendor/{vendorId}/product/create", produces = "text/html")
        public String create(){
            return "forward:/ProductCreate.html";
        }
}
