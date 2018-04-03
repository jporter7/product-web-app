package com.example.product.web.app.vendor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VendorUpdateController {
    public VendorUpdateController() { }

    @GetMapping(value = "/vendor/update", produces = "text/html")
    public String update() { return "forward:/vendorUpdate.html"; }
}