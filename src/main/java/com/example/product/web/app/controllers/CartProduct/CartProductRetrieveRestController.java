package com.example.product.web.app.controllers.CartProduct;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.cartproduct.CartProductRetrieveService;
import com.kleancierge.product.api.contract.cartproduct.ICartProductRetrieveService;
import com.kleancierge.product.api.model.cartproduct.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartProductRetrieveRestController {
    private ICartProductRetrieveService retrieveService;

    private Result result;

    public CartProductRetrieveRestController(ICartProductRetrieveService retrieveService) { this.retrieveService = retrieveService; }

    @GetMapping(value = "/cart/product/{id}")
    public Result retrieve(Long id) {
        retrieveService.execute(id, new CartProductRetrieveService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Model product) { result = Result.SUCCESS(product); }
        });

        return result;
    }
}
