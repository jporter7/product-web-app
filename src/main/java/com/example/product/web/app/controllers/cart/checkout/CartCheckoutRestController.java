package com.example.product.web.app.controllers.cart.checkout;

import com.kleancierge.product.api.contract.CheckoutResult;
import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.braintree.CartCheckoutService;
import com.kleancierge.product.api.contract.braintree.ICartCheckoutService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartCheckoutRestController {
    private ICartCheckoutService checkoutService;

    private Result result;

    public CartCheckoutRestController(ICartCheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping(value = "/carts/{id}/checkout")
    public Result checkout(@PathVariable Long id, String btCustomerId, String ccToken) {
        checkoutService.execute(id, btCustomerId, ccToken, new CartCheckoutService.ServiceResponse() {
            @Override
            public void success(CheckoutResult checkoutResult) {
                result = Result.SUCCESS(checkoutResult);
            }

            @Override
            public void errors(FieldErrors fieldErrors) {
                result = Result.ERROR(fieldErrors);
            }
        });

        return result;
    }
}
