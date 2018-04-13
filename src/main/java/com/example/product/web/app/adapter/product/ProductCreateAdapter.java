package com.example.product.web.app.adapter.product;

import com.example.product.web.app.model.product.CreateFormWA;
import com.example.product.web.app.model.product.ModelWA;
import com.kleancierge.product.api.converter.DollarConverter;
import com.kleancierge.product.api.repository.entity.Product;

import java.util.Locale;

public class ProductCreateAdapter {
    public ModelWA toWebApp(CreateFormWA createForm){
        ModelWA model = new ModelWA();
        model.setImgUrl(createForm.getImgUrl());
        model.setAltId(createForm.getAltId());
        model.setSummary(createForm.getSummary());
        model.setStatus(createForm.getStatus().toUpperCase(Locale.US));
        model.setPrice(createForm.getPrice());
        model.setDescription(createForm.getDescription());
        model.setName(createForm.getName());
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
