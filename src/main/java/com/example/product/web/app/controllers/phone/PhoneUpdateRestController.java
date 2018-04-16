package com.example.product.web.app.controllers.phone;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.phone.IPhoneUpdateService;
import com.kleancierge.product.api.contract.phone.PhoneUpdateService;
import com.kleancierge.product.api.model.phone.UpdateForm;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhoneUpdateRestController {
    private IPhoneUpdateService updateService;

    private Result result;

    public PhoneUpdateRestController(IPhoneUpdateService updateService) {
        this.updateService = updateService;
    }

    @PutMapping(value = "/phones/{id}")
    public Result update(UpdateForm form) {
        updateService.execute(form, new PhoneUpdateService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) {
                result = Result.ERROR(fieldErrors);
            }

            @Override
            public void success(Long id) {
                result = Result.SUCCESS(id);
            }
        });

        return result;
    }
}
