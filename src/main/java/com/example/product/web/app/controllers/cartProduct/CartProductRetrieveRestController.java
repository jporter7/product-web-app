package com.example.product.web.app.controllers.cartProduct;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.cartProduct.CartProductRetrieveService;
import com.kleancierge.product.api.contract.cartProduct.ICartProductRetrieveService;
import com.kleancierge.product.api.model.cartProduct.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartProductRetrieveRestController {
    private ICartProductRetrieveService retrieveService;

    private Result result;

    public CartProductRetrieveRestController(ICartProductRetrieveService retrieveService) {
        this.retrieveService = retrieveService;
    }

    @GetMapping(value = "/cart-products/{id}")
    public Result retrieve(@PathVariable Long id) {
        retrieveService.execute(id, new CartProductRetrieveService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) {
                result = Result.ERROR(fieldErrors);
            }

            @Override
            public void success(Model product) {
                result = Result.SUCCESS(product);
            }
        });

        return result;
    }
}
