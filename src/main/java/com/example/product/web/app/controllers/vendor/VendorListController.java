package com.example.product.web.app.controllers.vendor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class VendorListController {
    public VendorListController() {}

    @GetMapping(value = "/vendors/list", produces = "text/html")
    public String list(){
        return "forward:/VendorList.html";
    }
}
