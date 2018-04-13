package com.example.product.web.app.controllers.cartProductStatus;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.cartproductstatus.CartProductStatusListService;
import com.kleancierge.product.api.contract.cartproductstatus.ICartProductStatusListService;
import com.kleancierge.product.api.model.cartproductstatus.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartProductStatusListRestController {
    private ICartProductStatusListService listService;

    private Result result;

    public CartProductStatusListRestController(ICartProductStatusListService listService) { this.listService = listService; }

    @GetMapping(value = "/cart/cart-product-statuses/{pageIndex}")
    public Result list(@RequestParam("pageSize") int pageSize, @RequestParam("pageIndex") int pageIndex, Long id) {
        PageRequest page = new PageRequest(pageIndex, pageSize);

        listService.execute(id, page, new CartProductStatusListService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Page<Model> products) { result = Result.SUCCESS(products); }
        });

        return result;
    }
}
