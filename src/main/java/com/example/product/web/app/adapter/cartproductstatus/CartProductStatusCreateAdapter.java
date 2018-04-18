package com.example.product.web.app.adapter.cartproductstatus;

import com.example.product.web.app.model.cartproductstatus.CreateFormWA;
import com.example.product.web.app.model.cartproductstatus.ModelWA;
import com.kleancierge.product.api.repository.entity.CartProductStatus;
import org.springframework.web.bind.annotation.RequestParam;

public class CartProductStatusCreateAdapter {
    public ModelWA toWebApp(CreateFormWA createForm, @RequestParam("cartProductId") Long cartProductId) {
        ModelWA model = new ModelWA();
        model.setStatus(createForm.getStatus());
        model.setCartProductId(cartProductId);
        return model;
    }

    public CartProductStatus toContract(ModelWA model) {
        CartProductStatus cartProductStatus = new CartProductStatus();
        cartProductStatus.setStatus(cartProductStatus.getStatus());
        return cartProductStatus;
    }
}
