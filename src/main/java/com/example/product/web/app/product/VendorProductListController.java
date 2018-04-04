package com.example.product.web.app.product;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VendorProductListController {
    public VendorProductListController() { }

    @GetMapping(value = "/vendor/{vendorId}/products/list", produces = "text/html")
    public String list(){
        return "forward:/vendorProductList.html";
    }
}