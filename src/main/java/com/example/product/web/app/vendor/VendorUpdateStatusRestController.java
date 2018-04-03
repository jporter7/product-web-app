package com.example.product.web.app.vendor;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.vendor.IVendorUpdateStatusService;
import com.kleancierge.product.api.contract.vendor.VendorUpdateStatusService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorUpdateStatusRestController {
    private IVendorUpdateStatusService updateStatusService;

    private Result result;

    public VendorUpdateStatusRestController(IVendorUpdateStatusService updateStatusService) {
        this.updateStatusService = updateStatusService;
    }

    @PutMapping(value = "/vendor/update-status/{vendorId}")
    public Result updateStatus(Long id, String status) {
        updateStatusService.execute(id, status, new VendorUpdateStatusService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Long id) { result = Result.SUCCESS(id); }
        });

        return result;
    }
}
