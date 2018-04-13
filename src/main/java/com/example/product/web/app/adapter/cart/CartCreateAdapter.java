package com.example.product.web.app.adapter.cart;

import com.example.product.web.app.model.cart.ModelWA;
import com.kleancierge.product.api.repository.entity.Cart;

public class CartCreateAdapter {
    public Cart toContract(ModelWA model){
        Cart cart = new Cart();
        model.setLastModified(cart.getLastModified());
        model.setTransactionId(cart.getTransactionId());
        model.setId(cart.getId());
        return cart;
    }
}
