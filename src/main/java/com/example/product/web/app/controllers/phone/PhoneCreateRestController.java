package com.example.product.web.app.controllers.phone;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.phone.IPhoneCreateService;
import com.kleancierge.product.api.contract.phone.PhoneCreateService;
import com.kleancierge.product.api.model.phone.CreateForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneCreateRestController {
    private IPhoneCreateService createService;

    private Result result;

    public PhoneCreateRestController(IPhoneCreateService createService) { this.createService = createService; }

    @PostMapping(value = "/vendor/{vendorId}/contact/{contactId}/phone/create/{phoneId}")
    public Result create(CreateForm form) {
        createService.execute(form, new PhoneCreateService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Long id) { result = Result.SUCCESS(id); }
        });

        return result;
    }
}
