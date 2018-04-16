package com.example.product.web.app.controllers.contact;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.contact.ContactDeleteService;
import com.kleancierge.product.api.contract.contact.IContactDeleteService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactDeleteRestController {
    private IContactDeleteService deleteService;

    private Result result;

    public ContactDeleteRestController(IContactDeleteService deleteService) {
        this.deleteService = deleteService;
    }

    @DeleteMapping(value = "/contacts/{id}")
    public Result delete(@PathVariable Long id) {
        deleteService.execute(id, new ContactDeleteService.ServiceResponse() {
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
