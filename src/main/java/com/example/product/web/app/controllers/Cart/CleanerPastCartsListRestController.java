package com.example.product.web.app.controllers.Cart;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.cart.CleanerPastCartsListService;
import com.kleancierge.product.api.contract.cart.ICleanerPastCartsListService;
import com.kleancierge.product.api.model.cart.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CleanerPastCartsListRestController {
    private ICleanerPastCartsListService listService;

    private Result result;

    public CleanerPastCartsListRestController(ICleanerPastCartsListService listService) { this.listService = listService; }

    @GetMapping(value = "/carts/{pageNumber}")
    public Result list(@RequestParam("pageSize") int pageSize, @RequestParam("pageIndex") int pageIndex, Long id) {
        PageRequest page = new PageRequest(pageIndex, pageSize);

        listService.execute(id, page, new CleanerPastCartsListService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Page<Model> products) { result = Result.SUCCESS(products); }
        });

        return result;
    }
}