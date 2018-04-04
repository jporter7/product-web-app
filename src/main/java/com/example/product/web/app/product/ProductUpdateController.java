package com.example.product.web.app.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductUpdateController {
    public ProductUpdateController() { }

    @GetMapping(value = "/product/update", produces = "text/html")
    public String update() { return "forward:/productUpdate.html"; }
}
