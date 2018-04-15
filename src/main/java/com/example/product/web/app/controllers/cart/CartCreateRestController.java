package com.example.product.web.app.controllers.cart;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.cart.CartCreateService;
import com.kleancierge.product.api.contract.cart.ICartCreateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartCreateRestController {
    private ICartCreateService createService;

    private Result result;

    public CartCreateRestController(ICartCreateService createService) { this.createService = createService; }

    @PostMapping(value = "/cleaners/{cleanerId}/carts")
    public Result create(Long cleanerId) {
        createService.execute(cleanerId, new CartCreateService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Long id) { result = Result.SUCCESS(id); }
        });

        return result;
    }
}
