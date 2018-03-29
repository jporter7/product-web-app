package com.example.product.web.app.vendor;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.vendor.IVendorCreateService;
import com.kleancierge.product.api.contract.vendor.VendorCreateService;
import com.kleancierge.product.api.model.vendor.CreateForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VendorCreateController {
    public VendorCreateController() { }

    @GetMapping(value = "/vendor/registration", produces = "text/html")
    public String registration() {
        return "redirect:/vendorRegistration.html";
    }

}
