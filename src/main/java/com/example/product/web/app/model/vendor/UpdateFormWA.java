package com.example.product.web.app.model.vendor;

import com.kleancierge.product.api.repository.entity.Vendor;

/**
 * Form used for the update service for {@link Vendor}
 *
 * @property id - the id of the {@link Vendor} we wish to update
 * @property name - the new name we want to update for the {@link Vendor}
 * @property summary - the new summary we want to update for the {@link Vendor}
 * @property url - the new website url we want to update for the {@link Vendor}
 * @property address - the new business address we want to update for the {@link Vendor}
 * @property img url - the new business image we want to update for the {@link Vendor}
 */
public class UpdateFormWA {
    private Long id;
    private String name;
    private String summary;
    private String url;
    private String address;
    private String imgUrl;

    public UpdateFormWA() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
