package com.example.product.web.app.controllers.phone;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhoneUpdateController {
    public PhoneUpdateController() { }

    @GetMapping(value = "/vendor/{vendorId}/contact/{contactId}/phone/{phoneId}/update", produces = "text/html")
    public String update() { return "forward:/PhoneUpdate.html"; }
}
