package com.example.product.web.app.controllers.cartStatus;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.cartstatus.CartStatusRetrieveService;
import com.kleancierge.product.api.contract.cartstatus.ICartStatusRetrieveService;
import com.kleancierge.product.api.model.cartstatus.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartStatusRetrieveRestController {
    private ICartStatusRetrieveService retrieveService;

    private Result result;

    public CartStatusRetrieveRestController(ICartStatusRetrieveService retrieveService) { this.retrieveService = retrieveService; }

    @GetMapping(value = "/cart/cart-status/{id}")
    public Result retrieve(Long id) {
        retrieveService.execute(id, new CartStatusRetrieveService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Model product) { result = Result.SUCCESS(product); }
        });

        return result;
    }
}
