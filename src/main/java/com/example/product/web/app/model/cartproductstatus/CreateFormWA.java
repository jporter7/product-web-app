package com.example.product.web.app.model.cartproductstatus;

import com.kleancierge.product.api.repository.entity.CartProduct;
import com.kleancierge.product.api.repository.entity.CartProductStatus;

/**
 * Form used for creation service of {@link CartProductStatus} entity objects
 *
 * @property cartProductId - the CartProductStatus's {@link CartProduct} id
 * @property status - the CartProductStatus's status
 */

public class CreateFormWA {

    private Long cartProductId;
    private String status;

    public CreateFormWA() {

    }

    public void setCartProductId(Long cartProductId) { this.cartProductId = cartProductId; }

    public Long getCartProductId() { return cartProductId; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}
