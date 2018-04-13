package com.example.product.web.app.controllers.vendor;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.vendor.IVendorUpdateService;
import com.kleancierge.product.api.contract.vendor.VendorUpdateService;
import com.kleancierge.product.api.model.vendor.UpdateForm;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorUpdateRestController {
    private IVendorUpdateService updateService;

    private Result result;

    public VendorUpdateRestController(IVendorUpdateService updateService) { this.updateService = updateService; }

    @PutMapping(value = "/vendor/{id}")
    public Result update(UpdateForm form) {
        updateService.execute(form, new VendorUpdateService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Long id) { result = Result.SUCCESS(id); }
        });

        return result;
    }
}
