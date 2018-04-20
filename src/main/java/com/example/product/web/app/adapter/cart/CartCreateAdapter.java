package com.example.product.web.app.adapter.cart;

import com.example.product.web.app.model.cart.ModelWA;
import com.kleancierge.product.api.repository.entity.Cart;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

public class CartCreateAdapter {
    public Cart toContract(ModelWA model) {
        Cart cart = new Cart();
        model.setId(cart.getId());
        return cart;
    }
}
