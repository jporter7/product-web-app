package com.example.product.web.app.controllers.product;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.product.IVendorProductListService;
import com.kleancierge.product.api.contract.product.VendorProductListService;
import com.kleancierge.product.api.model.product.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VendorProductListController {
/*    private IVendorProductListService listService;

    private Result result;

    VendorProductListController(IVendorProductListService listService) { this.listService = listService; }

    @GetMapping(value = "/products")
    public Result list(Pageable page, VendorProductListService.ServiceResponse serviceResponse) {
        listService.execute(page, new VendorProductListService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Page<Model> people) { result = Result.SUCCESS(people); }
        });

        return result;
    }*/
}
