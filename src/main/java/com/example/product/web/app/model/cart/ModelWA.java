package com.example.product.web.app.model.cart;

import java.time.LocalDateTime;

public class ModelWA {

    private Long id;
    private String transactionId;
    private LocalDateTime lastModified;

    public ModelWA() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
