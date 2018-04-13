package com.example.product.web.app.adapter.cartproduct;

import com.example.product.web.app.model.cartproduct.CreateFormWA;
import com.example.product.web.app.model.cartproduct.ModelWA;
import com.kleancierge.product.api.repository.entity.CartProduct;

public class CartProductCreateAdapter {
    public ModelWA toWebApp(CreateFormWA createForm){
        ModelWA model = new ModelWA();
        model.setQuantity(createForm.getQuantity());
        return model;
    }

    public CartProduct toContract(ModelWA model){
        CartProduct cartProduct = new CartProduct();
        cartProduct.setQuantity(model.getQuantity());
        return cartProduct;
    }
}
