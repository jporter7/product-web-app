package com.example.product.web.app.model.product;

import com.kleancierge.product.api.repository.entity.Product;
import com.kleancierge.product.api.repository.entity.Vendor;

/**
 * Form used for the update service for {@link Product}
 *
 * @property id - the id of the {@link Product} we wish to update
 * @property vendorId - the {@link Vendor} that owns the {@link Product}
 * @property price - the new price we want to update for the {@link Product}
 * @property altId - the new altId we want to update for the {@link Product}
 * @property name - the new name we want to update for the {@link Product}
 * @property description - the new description we want to update for the {@link Product}
 * @property summary - the new summary we want to update for the {@link Product}
 * @property imgUrl - the new image url we want to update for the {@link Product}
 */
public class UpdateFormWA {
    private Long id;
    private Long vendorId;
    private String price;
    private String altId;
    private String name;
    private String description;
    private String summary;
    private String imgUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAltId() {
        return altId;
    }

    public void setAltId(String altId) {
        this.altId = altId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }
}
