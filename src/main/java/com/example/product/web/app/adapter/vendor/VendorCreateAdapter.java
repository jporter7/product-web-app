package com.example.product.web.app.adapter.vendor;

import com.example.product.web.app.model.vendor.CreateFormWA;
import com.example.product.web.app.model.vendor.ModelWA;
import com.kleancierge.product.api.repository.entity.Vendor;

public class VendorCreateAdapter {
    public ModelWA toWebApp(CreateFormWA createForm){
        ModelWA model = new ModelWA();
        model.setName(createForm.getName());
        model.setSummary(createForm.getSummary());
        model.setUrl(createForm.getUrl());
        model.setAddress(createForm.getAddress());
        model.setImgUrl(createForm.getImgUrl());
        model.setStatus(createForm.getStatus().toUpperCase());
        return model;
    }

    public Vendor toContract(ModelWA model){
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
