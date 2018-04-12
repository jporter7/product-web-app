package com.example.product.web.app.model.product;

import com.kleancierge.product.api.repository.entity.Product;

/**
 * @property id - the Product's id
 * @property altId - the Product's altId
 * @property name - the Product's name
 * @property price - the Product's price
 * @property description - the Product's detailed description
 * @property summary - the Product's succinct summary
 * @property imgUrl - the Product's image url
 * @property status - the Product's status (Active or Inactive)
 */
public class ModelWA {
    private Long id;
    private String altId;
    private String name;
    private String price;
    private String description;
    private String summary;
    private String imgUrl;
    private String status;

    public ModelWA() { }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getSummary() { return summary; }

    public void setSummary(String summary) { this.summary = summary; }

    public String getImgUrl() { return imgUrl; }

    public void setImgUrl(String imgUrl) { this.imgUrl = imgUrl; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAltId() { return altId; }

    public void setAltId(String altId) { this.altId = altId; }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getPrice() { return price; }

    public void setPrice(String price) { this.price = price; }
}
