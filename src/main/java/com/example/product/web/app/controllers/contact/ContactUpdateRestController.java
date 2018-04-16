package com.example.product.web.app.controllers.contact;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.contact.ContactUpdateService;
import com.kleancierge.product.api.contract.contact.IContactUpdateService;
import com.kleancierge.product.api.model.contact.UpdateForm;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactUpdateRestController {
    private IContactUpdateService updateService;

    private Result result;

    public ContactUpdateRestController(IContactUpdateService updateService) {
        this.updateService = updateService;
    }

    @PutMapping(value = "/contacts/{id}")
    public Result update(UpdateForm form) {
        updateService.execute(form, new ContactUpdateService.ServiceResponse() {
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
