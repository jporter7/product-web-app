package com.example.product.web.app.controllers.phone;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.phone.IPhoneRetrieveService;
import com.kleancierge.product.api.contract.phone.PhoneRetrieveService;
import com.kleancierge.product.api.model.phone.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneRetrieveRestController {
    private IPhoneRetrieveService retrieveService;

    private Result result;

    public PhoneRetrieveRestController(IPhoneRetrieveService retrieveService) { this.retrieveService = retrieveService; }

    @GetMapping(value = "/phone/{id}")
    public Result retrieve(@RequestParam("id") Long id) {
        retrieveService.execute(id, new PhoneRetrieveService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Model contact) { result = Result.SUCCESS(contact); }
        });

        return result;
    }
}
