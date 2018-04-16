package com.example.product.web.app.controllers.product;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.product.IProductUpdateService;
import com.kleancierge.product.api.contract.product.ProductUpdateService;
import com.kleancierge.product.api.model.product.UpdateForm;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductUpdateRestController {
    private IProductUpdateService updateService;

    private Result result;

    public ProductUpdateRestController(IProductUpdateService updateService) {
        this.updateService = updateService;
    }

    @PutMapping(value = "/vendors/{vendorId}/products/{id}")
    public Result update(UpdateForm form) {
        updateService.execute(form, new ProductUpdateService.ServiceResponse() {
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
