package com.example.product.web.app.controllers.cartProduct;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.cartProduct.CartProductDeleteService;
import com.kleancierge.product.api.contract.cartProduct.ICartProductDeleteService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartProductDeleteRestController {
    private ICartProductDeleteService deleteService;

    private Result result;

    public CartProductDeleteRestController(ICartProductDeleteService deleteService) {
        this.deleteService = deleteService;
    }

    @DeleteMapping(value = "/cart-products/{id}")
    public Result delete(@PathVariable Long id) {
        deleteService.execute(id, new CartProductDeleteService.ServiceResponse() {
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
