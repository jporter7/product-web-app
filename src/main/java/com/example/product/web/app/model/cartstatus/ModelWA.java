package com.example.product.web.app.model.cartstatus;

import com.kleancierge.product.api.repository.entity.Cart;
import com.kleancierge.product.api.repository.entity.CartStatus;

/**
 * Used as a read-only version of the {@link CartStatus} entity
 *
 * @property id - the {@link CartStatus} id
 * @property cartId - the {@link Cart} id
 * @property status the {@link CartStatus} status
 */
public class ModelWA {
    private Long id;
    private Long cartId;
    private String status;

    public ModelWA() {

    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getCartId() { return cartId; }

    public void setCartId(Long cartId) { this.cartId = cartId; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}
