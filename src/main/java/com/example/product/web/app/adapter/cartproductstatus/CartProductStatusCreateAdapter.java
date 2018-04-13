package com.example.product.web.app.adapter.cartproductstatus;

import com.example.product.web.app.model.cartproductstatus.CreateFormWA;
import com.example.product.web.app.model.cartproductstatus.ModelWA;
import com.kleancierge.product.api.repository.entity.CartProductStatus;

public class CartProductStatusCreateAdapter {
    public ModelWA toWebApp(CreateFormWA createForm){
        ModelWA model = new ModelWA();
        model.setStatus(createForm.getStatus());
        model.setCartProductId(createForm.getCartProductId());
        return model;
    }

    public CartProductStatus toContract(ModelWA model){
        CartProductStatus cartProductStatus = new CartProductStatus();
        cartProductStatus.setStatus(cartProductStatus.getStatus());
        return cartProductStatus;
    }
}
