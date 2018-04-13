package com.example.product.web.app.controllers.product;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.product.IProductRetrieveService;
import com.kleancierge.product.api.contract.product.ProductRetrieveService;
import com.kleancierge.product.api.model.product.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRetrieveRestController {
    private IProductRetrieveService retrieveService;

    private Result result;

    public ProductRetrieveRestController(IProductRetrieveService retrieveService) { this.retrieveService = retrieveService; }

    @GetMapping(value = "/product/{id}")
    public Result retrieve(@RequestParam("id") Long id) {
        retrieveService.execute(id, new ProductRetrieveService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Model product) { result = Result.SUCCESS(product); }
        });

        return result;
    }
}
