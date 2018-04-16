package com.example.product.web.app.controllers.cart;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.cart.CartEmptyService;
import com.kleancierge.product.api.contract.cart.ICartEmptyService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartEmptyRestController {
    private ICartEmptyService deleteService;

    private Result result;

    public CartEmptyRestController(ICartEmptyService deleteService) { this.deleteService = deleteService; }

    @DeleteMapping(value = "/carts/{id}")
    public Result delete(@PathVariable Long id) {
        deleteService.execute(id, new CartEmptyService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Long id) { result = Result.SUCCESS(id); }
        });

        return result;
    }
}