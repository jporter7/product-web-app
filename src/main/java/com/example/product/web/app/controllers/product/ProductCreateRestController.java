package com.example.product.web.app.controllers.product;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.product.IProductCreateService;
import com.kleancierge.product.api.contract.product.ProductCreateService;
import com.kleancierge.product.api.model.product.CreateForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductCreateRestController {
    private IProductCreateService createService;

    private Result result;

    public ProductCreateRestController(IProductCreateService createService) { this.createService = createService; }

    @PostMapping(value = "/product-management/vendor/{vendorId}/product")
    public Result create(CreateForm form) {
        createService.execute(form, new ProductCreateService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Long id) { result = Result.SUCCESS(id); }
        });

        return result;
    }
}
