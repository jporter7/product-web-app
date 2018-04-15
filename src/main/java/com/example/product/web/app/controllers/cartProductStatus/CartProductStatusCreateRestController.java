package com.example.product.web.app.controllers.cartProductStatus;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.cartproductstatus.CartProductStatusCreateService;
import com.kleancierge.product.api.contract.cartproductstatus.ICartProductStatusCreateService;
import com.kleancierge.product.api.model.cartproductstatus.CreateForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartProductStatusCreateRestController {
    private ICartProductStatusCreateService createService;

    private Result result;

    public CartProductStatusCreateRestController(ICartProductStatusCreateService createService) { this.createService = createService; }

    @PostMapping(value = "/cart-products/{cartProductId}/cart-product-statuses")
    public Result create(CreateForm form) {
        createService.execute(form, new CartProductStatusCreateService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Long id) { result = Result.SUCCESS(id); }
        });

        return result;
    }
}
