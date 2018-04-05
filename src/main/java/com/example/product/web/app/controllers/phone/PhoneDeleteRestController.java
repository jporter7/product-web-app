package com.example.product.web.app.controllers.phone;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.phone.IPhoneDeleteService;
import com.kleancierge.product.api.contract.phone.PhoneDeleteService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneDeleteRestController {
    private IPhoneDeleteService deleteService;

    private Result result;

    public PhoneDeleteRestController(IPhoneDeleteService deleteService) { this.deleteService = deleteService; }

    @DeleteMapping(value = "/vendor/{vendorId}/contact/{contactId}/phone/{phoneId}/delete")
    public Result delete(Long id) {
        deleteService.execute(id, new PhoneDeleteService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Long id) { result = Result.SUCCESS(id); }
        });

        return result;
    }
}
