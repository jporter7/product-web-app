package com.example.product.web.app.contact;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactCreateController {
    public ContactCreateController() { }

    @GetMapping(value = "/vendor/{vendorId}/contact/create", produces = "text/html")
    public String create() {
        return "forward:/contactCreate.html";
    }
}
