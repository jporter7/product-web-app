package com.example.product.web.app.controllers.CartProduct;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.cartproduct.CartProductDeleteService;
import com.kleancierge.product.api.contract.cartproduct.ICartProductDeleteService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartProductDeleteRestController {
    private ICartProductDeleteService deleteService;

    private Result result;

    public CartProductDeleteRestController(ICartProductDeleteService deleteService) { this.deleteService = deleteService; }

    @DeleteMapping(value = "/cart/product/{id}")
    public Result delete(Long id) {
        deleteService.execute(id, new CartProductDeleteService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Long id) { result = Result.SUCCESS(id); }
        });

        return result;
    }
}
