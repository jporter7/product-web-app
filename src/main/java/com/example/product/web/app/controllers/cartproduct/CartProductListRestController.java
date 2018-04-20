package com.example.product.web.app.controllers.cartproduct;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.cartProduct.CartProductListService;
import com.kleancierge.product.api.contract.cartProduct.ICartProductListService;
import com.kleancierge.product.api.model.cartProduct.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartProductListRestController {
    private ICartProductListService listService;

    private Result result;

    public CartProductListRestController(ICartProductListService listService) {
        this.listService = listService;
    }

    @GetMapping(value = "/carts/{id}/cart-products")
    public Result list(@RequestParam("pageSize") int pageSize, @RequestParam("pageIndex") int pageIndex,
                       @PathVariable Long id) {
        PageRequest page = new PageRequest(pageIndex, pageSize);

        listService.execute(id, page, new CartProductListService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) {
                result = Result.ERROR(fieldErrors);
            }

            @Override
            public void success(Page<Model> products) {
                result = Result.SUCCESS(products);
            }
        });

        return result;
    }
}
