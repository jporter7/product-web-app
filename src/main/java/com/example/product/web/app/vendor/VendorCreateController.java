package com.example.product.web.app.vendor;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class VendorCreateController {
    public VendorCreateController() { }

    @GetMapping(value = "/vendor/registration", produces = "text/html")
    public String registration() {
        return "redirect:/vendorCreate.html";
    }

}
