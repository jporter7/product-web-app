package com.example.product.web.app.controllers.cartStatus;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.cartstatus.CartStatusCreateService;
import com.kleancierge.product.api.contract.cartstatus.ICartStatusCreateService;
import com.kleancierge.product.api.model.cartstatus.CreateForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartStatusCreateRestController {
    private ICartStatusCreateService createService;

    private Result result;

    public CartStatusCreateRestController(ICartStatusCreateService createService) { this.createService = createService; }

    @PostMapping(value = "/carts/{cartId}/cart-statuses")
    public Result create(CreateForm form) {
        createService.execute(form, new CartStatusCreateService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Long id) { result = Result.SUCCESS(id); }
        });

        return result;
    }
}
