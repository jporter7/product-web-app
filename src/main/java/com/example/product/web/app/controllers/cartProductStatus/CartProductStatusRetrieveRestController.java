package com.example.product.web.app.controllers.cartProductStatus;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.cartProductStatus.CartProductStatusRetrieveService;
import com.kleancierge.product.api.contract.cartProductStatus.ICartProductStatusRetrieveService;
import com.kleancierge.product.api.model.cartProductStatus.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartProductStatusRetrieveRestController {
    private ICartProductStatusRetrieveService retrieveService;

    private Result result;

    public CartProductStatusRetrieveRestController(ICartProductStatusRetrieveService retrieveService) {
        this.retrieveService = retrieveService;
    }

    @GetMapping(value = "/cart-product-statuses/{id}")
    public Result retrieve(@PathVariable Long id) {
        retrieveService.execute(id, new CartProductStatusRetrieveService.ServiceResponse() {
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
