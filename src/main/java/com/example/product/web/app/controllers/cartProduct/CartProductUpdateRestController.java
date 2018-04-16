package com.example.product.web.app.controllers.cartProduct;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.cartProduct.CartProductUpdateService;
import com.kleancierge.product.api.contract.cartProduct.ICartProductUpdateService;
import com.kleancierge.product.api.model.cartProduct.UpdateForm;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartProductUpdateRestController {
    private ICartProductUpdateService updateService;

    private Result result;

    public CartProductUpdateRestController(ICartProductUpdateService updateService) {
        this.updateService = updateService;
    }

    @PutMapping(value = "/cart-products/{id}")
    public Result update(UpdateForm form) {
        updateService.execute(form, new CartProductUpdateService.ServiceResponse() {
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