package com.example.product.web.app.controllers.vendor;

import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.braintree.ISaveMerchantIdService;
import com.kleancierge.product.api.contract.braintree.SaveMerchantIdService;
import com.kleancierge.product.api.model.account.MerchantForm;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaveMerchantIdRestController {
    private ISaveMerchantIdService idService;

    private Result result;

    public SaveMerchantIdRestController(ISaveMerchantIdService idService) {
        this.idService = idService;
    }

    @PutMapping(value = "/vendors/{id}/btMerchantId")
    public Result execute(@PathVariable("id") Long id, MerchantForm merchantForm, String email) {
        idService.execute(merchantForm, email, id, new SaveMerchantIdService.ServiceResponse() {
            @Override
            public void success() { result = Result.SUCCESS(null); }

            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }
        });

        return result;
    }
}
