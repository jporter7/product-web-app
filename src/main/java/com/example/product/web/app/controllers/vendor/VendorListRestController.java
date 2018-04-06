package com.example.product.web.app.controllers.vendor;


import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import com.kleancierge.product.api.contract.vendor.IVendorListService;
import com.kleancierge.product.api.contract.vendor.VendorListService;
import com.kleancierge.product.api.model.vendor.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorListRestController {
    private IVendorListService listService;

    private Result result;

    public VendorListRestController(IVendorListService listService) { this.listService = listService; }

    @GetMapping(value = "/vendors/list")
    public Result list(@RequestParam("pageSize") int pageSize, @RequestParam("pageIndex") int pageIndex) {
        PageRequest request = new PageRequest(pageIndex, pageSize);

        listService.execute(request, new VendorListService.ServiceResponse() {
            @Override
            public void errors(FieldErrors fieldErrors) { result = Result.ERROR(fieldErrors); }

            @Override
            public void success(Page<Model> vendors) { result = Result.SUCCESS(vendors); }
        });

        return result;
    }
}
