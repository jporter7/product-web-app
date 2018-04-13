package com.example.product.web.app.adapter.cartstatus;

import com.example.product.web.app.model.cartstatus.CreateFormWA;
import com.example.product.web.app.model.cartstatus.ModelWA;
import com.kleancierge.product.api.repository.entity.CartStatus;

public class CartStatusCreateAdapter {
    public ModelWA toWebApp(CreateFormWA createForm){
        ModelWA model = new ModelWA();
        model.setStatus(createForm.getStatus());
        model.setCartId(createForm.getCartId());
        return model;
    }

    public CartStatus toContract(ModelWA model){
        CartStatus cartStatus = new CartStatus();
        cartStatus.setStatus(cartStatus.getStatus());
        return cartStatus;
    }
}
