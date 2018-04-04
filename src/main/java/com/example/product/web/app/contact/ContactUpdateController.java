package com.example.product.web.app.contact;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactUpdateController {
    public ContactUpdateController() { }

    @GetMapping(value = "/vendor/{vendorId}/contact/{contactId}/update", produces = "text/html")
    public String update() { return "forward:/contactUpdate.html"; }
}
