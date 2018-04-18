package com.example.product.web.app.adapter.cartstatus;

import com.example.product.web.app.model.cartstatus.CreateFormWA;
import com.example.product.web.app.model.cartstatus.ModelWA;
import com.kleancierge.product.api.repository.entity.CartStatus;
import org.springframework.web.bind.annotation.RequestParam;

public class CartStatusCreateAdapter {
    public ModelWA toWebApp(CreateFormWA createForm, @RequestParam("cartId") Long cartId) {
        ModelWA model = new ModelWA();
        model.setStatus(createForm.getStatus());
        model.setCartId(cartId);
        return model;
    }

    public CartStatus toContract(ModelWA model) {
        CartStatus cartStatus = new CartStatus();
        cartStatus.setStatus(cartStatus.getStatus());
        return cartStatus;
    }
}
