package com.example.product.web.app.controllers.cartproduct;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.cartProduct.CartProductCreateService;
import com.kleancierge.product.api.contract.cartProduct.ICartProductCreateService;
import com.kleancierge.product.api.model.cartProduct.CreateForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartProductCreateRestController {
    private ICartProductCreateService createService;

    private Result result;

    public CartProductCreateRestController(ICartProductCreateService createService) {
        this.createService = createService;
    }

    @PostMapping(value = "/carts/{cartId}/cart-products")
    public Result create(CreateForm form) {
        createService.execute(form, new CartProductCreateService.ServiceResponse() {
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
