package com.example.product.web.app.controllers.cart.checkout;

import com.kleancierge.product.api.contract.CheckoutResult;
import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.braintree.CartCheckoutRetryService;
import com.kleancierge.product.api.contract.braintree.ICartCheckoutRetryService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartCheckoutRetryRestController {
    private ICartCheckoutRetryService checkoutRetryService;

    private Result result;

    public CartCheckoutRetryRestController(ICartCheckoutRetryService checkoutRetryService) {
        this.checkoutRetryService = checkoutRetryService;
    }

    @PostMapping(value = "/cart/{id}/checkout-retry")
    public Result checkoutRetry(@PathVariable Long id, String btCustomerId, String ccToken) {
        checkoutRetryService.execute(id, btCustomerId, ccToken, new CartCheckoutRetryService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(CheckoutResult checkoutResult) { result = Result.SUCCESS(checkoutResult); }
        });

        return result;
    }
}
