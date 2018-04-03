package com.example.product.web.app.vendor;


import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.vendor.IVendorListService;
import com.kleancierge.product.api.contract.vendor.VendorListService;
import com.kleancierge.product.api.model.vendor.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorListRestController {
    private IVendorListService listService;

    private Result result;

    public VendorListRestController(IVendorListService listService) { this.listService = listService; }

    @RequestMapping(method = RequestMethod.GET, value = "/vendors/page/{pageNumber}")
    public Result list(Pageable page) {
        listService.execute(page, new VendorListService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Page<Model> vendors) { result = Result.SUCCESS(vendors); }
        });

        return result;
    }
}
