package com.example.product.web.app.controllers.CartStatus;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.cartstatus.CartStatusListService;
import com.kleancierge.product.api.contract.cartstatus.ICartStatusListService;
import com.kleancierge.product.api.model.cartstatus.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartStatusListRestController {
    private ICartStatusListService listService;

    private Result result;

    public CartStatusListRestController(ICartStatusListService listService) { this.listService = listService; }

    @GetMapping(value = "/cart/cart-status")
    public Result list(Pageable page, Long id) {
        listService.execute(id, page, new CartStatusListService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Page<Model> products) { result = Result.SUCCESS(products); }
        });

        return result;
    }
}
