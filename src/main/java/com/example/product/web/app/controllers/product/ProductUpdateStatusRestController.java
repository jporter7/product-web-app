package com.example.product.web.app.controllers.product;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.product.IProductUpdateStatusService;
import com.kleancierge.product.api.contract.product.ProductUpdateStatusService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductUpdateStatusRestController {
    private IProductUpdateStatusService updateStatusService;

    private Result result;

    public ProductUpdateStatusRestController(IProductUpdateStatusService updateStatusService) {
        this.updateStatusService = updateStatusService;
    }

    @PutMapping(value = "/products/{id}/status")
    public Result updateStatus(@PathVariable Long id, String status) {
        updateStatusService.execute(id, status, new ProductUpdateStatusService.ServiceResponse() {
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
