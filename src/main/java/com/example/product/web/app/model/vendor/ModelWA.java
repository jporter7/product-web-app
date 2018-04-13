package com.example.product.web.app.model.vendor;

import com.kleancierge.product.api.repository.entity.Vendor;

/**
 * @property id - the Vendor's id
 * @property name - the Vendor's name
 * @property summary - the Vendor's summary
 * @property url - the Vendor's website url
 * @property status - the Vendor's status (Active or Inactive)
 * @property address - the Vendor's business address
 * @property imgUrl - the Vendor's business picture
 */
public class ModelWA {
    private Long id;
    private String name;
    private String summary;
    private String url;
    private String status;
    private String address;
    private String imgUrl;

    public ModelWA() { }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name;}

    public String getSummary() { return summary;}

    public void setSummary(String summary) { this.summary = summary; }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public String getStatus() { return status; }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getImgUrl() { return imgUrl; }

    public void setImgUrl(String imgUrl) { this.imgUrl = imgUrl; }
}
