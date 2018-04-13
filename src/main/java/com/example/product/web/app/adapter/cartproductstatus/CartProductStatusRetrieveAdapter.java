package com.example.product.web.app.adapter.cartproductstatus;

import com.example.product.web.app.model.cartproductstatus.ModelWA;
import com.kleancierge.product.api.repository.entity.CartProductStatus;

public class CartProductStatusRetrieveAdapter {
    public CartProductStatus toContract(ModelWA model){
        CartProductStatus cartProductStatus = new CartProductStatus();
        cartProductStatus.setStatus(cartProductStatus.getStatus());
        return cartProductStatus;
    }
}
