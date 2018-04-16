package com.example.product.web.app.model.cartproductstatus;

import com.kleancierge.product.api.repository.entity.CartProduct;
import com.kleancierge.product.api.repository.entity.CartProductStatus;

/**
 * Used as a read-only version of the {@link CartProductStatus} entity
 *
 * @property id - the {@link CartProductStatus} id
 * @property cartProductId - the {@link CartProduct} id
 * @property status the {@link CartProductStatus} status
 */
public class ModelWA {
    private Long id;
    private Long cartProductId;
    private String status;

    public ModelWA() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(Long cartProductId) {
        this.cartProductId = cartProductId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

