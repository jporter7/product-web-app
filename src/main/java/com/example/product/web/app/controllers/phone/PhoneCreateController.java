package com.example.product.web.app.controllers.phone;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhoneCreateController {
    public PhoneCreateController() { }

    @GetMapping(value = "/vendor/{vendorId}/contact/{contactId}/phone/create", produces = "text/html")
    public String create() {
        return "forward:/phoneCreate.html";
    }
}
