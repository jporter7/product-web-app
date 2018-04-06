package com.example.product.web.app.controllers.contact;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VendorContactListController {
    public VendorContactListController() { }

    @GetMapping(value = "/vendor/{vendorId}/contacts/list", produces = "text/html")
    public String list(){
        return "forward:/VendorContactList.html";
    }
}
