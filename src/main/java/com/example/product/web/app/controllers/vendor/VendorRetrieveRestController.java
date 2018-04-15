package com.example.product.web.app.controllers.vendor;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.vendor.IVendorRetrieveService;
import com.kleancierge.product.api.contract.vendor.VendorRetrieveService;
import com.kleancierge.product.api.model.vendor.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorRetrieveRestController {
    private IVendorRetrieveService retrieveService;

    private Result result;

    public VendorRetrieveRestController(IVendorRetrieveService retrieveService) { this.retrieveService = retrieveService; }

    @GetMapping(value = "/vendors/{id}")
    public Result retrieve(@RequestParam("id") Long id) {
        retrieveService.execute(id, new VendorRetrieveService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Model vendor) { result = Result.SUCCESS(vendor); }
        });

        return result;
    }
}