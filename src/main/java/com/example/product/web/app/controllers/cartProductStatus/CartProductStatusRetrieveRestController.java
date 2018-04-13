package com.example.product.web.app.controllers.cartProductStatus;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.cartproductstatus.CartProductStatusRetrieveService;
import com.kleancierge.product.api.contract.cartproductstatus.ICartProductStatusRetrieveService;
import com.kleancierge.product.api.model.cartproductstatus.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartProductStatusRetrieveRestController {
    private ICartProductStatusRetrieveService retrieveService;

    private Result result;

    public CartProductStatusRetrieveRestController(ICartProductStatusRetrieveService retrieveService) { this.retrieveService = retrieveService; }

    @GetMapping(value = "/cart/cart-product-status/{id}")
    public Result retrieve(Long id) {
        retrieveService.execute(id, new CartProductStatusRetrieveService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Model product) { result = Result.SUCCESS(product); }
        });

        return result;
    }
}
