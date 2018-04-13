package com.example.product.web.app.model.cartproduct;

public class CreateFormWA {

    private int quantity;
    private Long productId;
    private Long cartId;

    public CreateFormWA() { }

    public int getQuantity() {  return quantity;  }

    public void setQuantity(int quantity) {  this.quantity = quantity;   }

    public Long getProductId() {return productId;}

    public void setProductId(Long productId) {this.productId = productId;}

    public Long getCartId() { return cartId; }

    public void setCartId(Long cartId) { this.cartId = cartId; }

}
