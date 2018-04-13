package com.example.product.web.app.adapter.cartproduct;

import com.example.product.web.app.model.cartproduct.ModelWA;
import com.kleancierge.product.api.repository.entity.CartProduct;

public class CartProductRetrieveAdapter {
    public CartProduct toContract(ModelWA model){
        CartProduct cartProduct = new CartProduct();
        cartProduct.setQuantity(model.getQuantity());
        return cartProduct;
    }
}
