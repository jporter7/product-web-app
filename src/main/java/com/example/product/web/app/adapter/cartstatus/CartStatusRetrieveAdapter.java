package com.example.product.web.app.adapter.cartstatus;

import com.example.product.web.app.model.cartstatus.ModelWA;
import com.kleancierge.product.api.repository.entity.CartStatus;

public class CartStatusRetrieveAdapter {
    public CartStatus toContract(ModelWA model){
        CartStatus cartStatus = new CartStatus();
        cartStatus.setStatus(cartStatus.getStatus());
        return cartStatus;
    }
}
