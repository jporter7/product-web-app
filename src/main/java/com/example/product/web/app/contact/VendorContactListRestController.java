package com.example.product.web.app.contact;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.contact.IVendorContactListService;
import com.kleancierge.product.api.contract.contact.VendorContactListService;
import com.kleancierge.product.api.model.contact.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorContactListRestController {
    private IVendorContactListService listService;

    private Result result;

    public VendorContactListRestController(IVendorContactListService listService) { this.listService = listService; }

    @GetMapping(value = "/vendor/{vendorId}/contacts/list/{pageNumber}")
    public Result list(Pageable page, Long id) {
        listService.execute(id, page, new VendorContactListService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Page<Model> products) { result = Result.SUCCESS(products); }
        });

        return result;
    }
}
