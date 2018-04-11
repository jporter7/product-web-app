package com.example.product.web.app.controllers.Cart;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.cart.CartRetrieveService;
import com.kleancierge.product.api.contract.cart.ICartRetrieveService;
import com.kleancierge.product.api.model.cart.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartRetrieveRestController {
    private ICartRetrieveService retrieveService;

    private Result result;

    public CartRetrieveRestController(ICartRetrieveService retrieveService) { this.retrieveService = retrieveService; }

    @GetMapping(value = "/cleaner/{cleanerId}/cart/{cartId}")
    public Result retrieve(Long id) {
        retrieveService.execute(id, new CartRetrieveService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Model contact) { result = Result.SUCCESS(contact); }
        });

        return result;
    }
}
