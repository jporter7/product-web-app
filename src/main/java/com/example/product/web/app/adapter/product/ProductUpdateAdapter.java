package com.example.product.web.app.adapter.product;

import com.example.product.web.app.model.product.ModelWA;
import com.example.product.web.app.model.product.UpdateFormWA;
import com.kleancierge.product.api.converter.DollarConverter;
import com.kleancierge.product.api.repository.entity.Product;

import java.util.Locale;

public class ProductUpdateAdapter {
    public ModelWA toWebApp(UpdateFormWA updateForm){
        ModelWA model = new ModelWA();
        model.setImgUrl(updateForm.getImgUrl());
        model.setAltId(updateForm.getAltId());
        model.setSummary(updateForm.getSummary());
        model.setPrice(updateForm.getPrice());
        model.setDescription(updateForm.getDescription());
        model.setName(updateForm.getName());
        return model;
    }

    public Product toContract(ModelWA model){
        Product product = new Product();
        product.setImgUrl(model.getImgUrl());
        product.setAltId(model.getAltId());
        product.setSummary(model.getSummary());
        product.setStatus(Product.Status.valueOf(model.getStatus().toUpperCase(Locale.US)));
        product.setPrice(DollarConverter.fromStringToDollarValue(model.getPrice()));
        product.setDescription(model.getDescription());
        product.setName(model.getName());
        return product;
    }
}
