package com.example.product.web.app.controllers.phone;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactPhoneListController {
    public ContactPhoneListController() { }

    @GetMapping(value = "/vendor/{vendorId}/contact/{contactId}/phones/list", produces = "text/html")
    public String list(){
        return "forward:/ContactPhoneList.html";
    }
}
