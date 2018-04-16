package com.example.product.web.app.controllers.product;


import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.product.IVendorProductListService;
import com.kleancierge.product.api.contract.product.VendorProductListService;
import com.kleancierge.product.api.model.product.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorProductListRestController {
    private IVendorProductListService listService;

    private Result result;

    public VendorProductListRestController(IVendorProductListService listService) {
        this.listService = listService;
    }

    @GetMapping(value = "/vendors/{id}/products")
    public Result list(@RequestParam("pageSize") int pageSize, @RequestParam("pageIndex") int pageIndex,
                       @PathVariable("id") Long id) {
        PageRequest page = new PageRequest(pageIndex, pageSize);

        listService.execute(id, page, new VendorProductListService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) {
                result = Result.ERROR(fieldErrors);
            }

            @Override
            public void success(Page<Model> products) {
                result = Result.SUCCESS(products);
            }
        });

        return result;
    }
}