package com.example.product.web.app.contact;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.contact.ContactCreateService;
import com.kleancierge.product.api.contract.contact.IContactCreateService;
import com.kleancierge.product.api.model.contact.CreateForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactCreateRestController {
    private IContactCreateService createService;

    private Result result;

    public ContactCreateRestController(IContactCreateService createService) { this.createService = createService; }

    @PostMapping(value = "/vendor/{vendorId}/contact/create/{contactId}")
    public Result retrieve(CreateForm form) {
        createService.execute(form, new ContactCreateService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Long id) { result = Result.SUCCESS(id); }
        });

        return result;
    }
}
