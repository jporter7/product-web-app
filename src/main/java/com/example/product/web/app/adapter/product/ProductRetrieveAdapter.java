package com.example.product.web.app.adapter.product;

import com.example.product.web.app.model.product.ModelWA;
import com.kleancierge.product.api.converter.DollarConverter;
import com.kleancierge.product.api.repository.entity.Product;

import java.util.Locale;

public class ProductRetrieveAdapter {
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
