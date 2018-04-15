package com.example.product.web.app.controllers.phone;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.phone.ContactPhoneListService;
import com.kleancierge.product.api.contract.phone.IContactPhoneListService;
import com.kleancierge.product.api.model.phone.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactPhoneListRestController {
    private IContactPhoneListService listService;

    private Result result;

    public ContactPhoneListRestController(IContactPhoneListService listService) { this.listService = listService; }

    @GetMapping(value = "/contacts/{id}/phones")
    public Result list(@RequestParam("pageSize") int pageSize, @RequestParam("pageIndex") int pageIndex,
                       @PathVariable("id") Long id) {
        PageRequest page = new PageRequest(pageIndex, pageSize);

        listService.execute(id, page, new ContactPhoneListService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Page<Model> products) { result = Result.SUCCESS(products); }
        });

        return result;
    }
}