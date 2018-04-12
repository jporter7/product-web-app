package com.example.product.web.app.controllers.CartProduct;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.cartproduct.CartProductListService;
import com.kleancierge.product.api.contract.cartproduct.ICartProductListService;
import com.kleancierge.product.api.model.cartproduct.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListRestController {
    private ICartProductListService listService;

    private Result result;

    public ListRestController(ICartProductListService listService) { this.listService = listService; }

    @GetMapping(value = "/cart/products")
    public Result list(Pageable page, Long id) {
        listService.execute(id, page, new CartProductListService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Page<Model> products) { result = Result.SUCCESS(products); }
        });

        return result;
    }
}
