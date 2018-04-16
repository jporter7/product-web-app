package com.example.product.web.app.adapter.vendor;

import com.example.product.web.app.model.vendor.ModelWA;
import com.kleancierge.product.api.repository.entity.Vendor;

public class VendorRetrieveAdapter {
    public Vendor toContract(ModelWA model) {
        Vendor vendor = new Vendor();
        vendor.setName(model.getName());
        vendor.setSummary(model.getSummary());
        vendor.setUrl(model.getUrl());
        vendor.setAddress(model.getAddress());
        vendor.setImgUrl(model.getImgUrl());
        vendor.setStatus(Vendor.Status.valueOf(model.getStatus().toUpperCase()));
        return vendor;
    }
}
