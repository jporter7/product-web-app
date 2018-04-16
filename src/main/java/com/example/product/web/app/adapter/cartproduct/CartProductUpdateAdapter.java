package com.example.product.web.app.adapter.cartproduct;

import com.example.product.web.app.model.cartproduct.ModelWA;
import com.example.product.web.app.model.cartproduct.UpdateFormWA;
import com.kleancierge.product.api.repository.entity.CartProduct;

public class CartProductUpdateAdapter {
    public ModelWA toWebApp(UpdateFormWA createForm) {
        ModelWA model = new ModelWA();
        model.setQuantity(createForm.getQuantity());
        return model;
    }

    public CartProduct toContract(ModelWA model) {
        CartProduct cartProduct = new CartProduct();
        cartProduct.setQuantity(model.getQuantity());
        return cartProduct;
    }
}
