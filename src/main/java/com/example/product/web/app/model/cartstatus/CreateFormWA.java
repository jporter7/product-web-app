package com.example.product.web.app.model.cartstatus;

import com.kleancierge.product.api.repository.entity.Cart;
import com.kleancierge.product.api.repository.entity.CartStatus;

/**
 * Form used for creation service of {@link CartStatus} entity objects
 *
 * @property cartId - the CartStatus's {@link Cart} id
 * @property status - the CartStatus's status
 */
public class CreateFormWA {
    private Long cartId;
    private String status;

    public CreateFormWA() {

    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getCartId() {
        return cartId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
