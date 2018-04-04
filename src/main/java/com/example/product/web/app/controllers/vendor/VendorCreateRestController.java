package com.example.product.web.app.controllers.vendor;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.vendor.IVendorCreateService;
import com.kleancierge.product.api.contract.vendor.VendorCreateService;
import com.kleancierge.product.api.model.vendor.CreateForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorCreateRestController {
    private IVendorCreateService createService;

    private Result result;

    public VendorCreateRestController(IVendorCreateService createService) { this.createService = createService; }

    @PostMapping(value = "/vendor/registration/{id}")
    public Result retrieve(CreateForm form) {
        createService.execute(form, new VendorCreateService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Long id) { result = Result.SUCCESS(id); }
        });

        return result;
    }
}