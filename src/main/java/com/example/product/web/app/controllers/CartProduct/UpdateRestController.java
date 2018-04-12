package com.example.product.web.app.controllers.CartProduct;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.cartproduct.CartProductUpdateService;
import com.kleancierge.product.api.contract.cartproduct.ICartProductUpdateService;
import com.kleancierge.product.api.model.cartproduct.UpdateForm;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateRestController {
    private ICartProductUpdateService updateService;

    private Result result;

    public UpdateRestController(ICartProductUpdateService updateService) {
        this.updateService = updateService;
    }

    @PutMapping(value = "/cart/product/{id}")
    public Result update(UpdateForm form) {
        updateService.execute(form, new CartProductUpdateService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) {
                result = Result.ERROR(fieldErrors);
            }

            @Override
            public void success(Long id) {
                result = Result.SUCCESS(id);
            }
        });

        return result;
    }
}