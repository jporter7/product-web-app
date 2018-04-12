package com.example.product.web.app.controllers.CartProduct;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.cartproduct.CartProductUpdateStatusService;
import com.kleancierge.product.api.contract.cartproduct.ICartProductUpdateStatusService;
import org.springframework.web.bind.annotation.PutMapping;

public class UpdateStatusRestConroller {
    private ICartProductUpdateStatusService updateStatusService;

    private Result result;

    public UpdateStatusRestConroller(ICartProductUpdateStatusService updateStatusService) {
        this.updateStatusService = updateStatusService;
    }

    @PutMapping(value = "/cart/product/{id}")
    public Result updateStatus(Long id, String status) {
        updateStatusService.execute(id, status, new CartProductUpdateStatusService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Long id) { result = Result.SUCCESS(id); }
        });

        return result;
    }
}
