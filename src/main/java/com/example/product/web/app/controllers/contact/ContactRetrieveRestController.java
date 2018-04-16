package com.example.product.web.app.controllers.contact;


import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.contact.ContactRetrieveService;
import com.kleancierge.product.api.contract.contact.IContactRetrieveService;
import com.kleancierge.product.api.model.contact.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactRetrieveRestController {
    private IContactRetrieveService retrieveService;

    private Result result;

    public ContactRetrieveRestController(IContactRetrieveService retrieveService) { this.retrieveService = retrieveService; }

    @GetMapping(value = "/contacts/{id}")
    public Result retrieve(@PathVariable Long id) {
        retrieveService.execute(id, new ContactRetrieveService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Model contact) { result = Result.SUCCESS(contact); }
        });

        return result;
    }
}
