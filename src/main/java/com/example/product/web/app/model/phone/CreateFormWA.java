package com.example.product.web.app.model.phone;

import com.kleancierge.product.api.repository.entity.Contact;
import com.kleancierge.product.api.repository.entity.Phone;

/**
 * Form used for creation services of {@link Phone}
 *
 * @property contactId - the Phone's {@link Contact} id
 * @property areaCode - the Phone's area code
 * @property number - the Phone's base number
 * @property extension - the Phone's optional extension
 * @property type - the Phone's type (Work or Mobile)
 */
public class CreateFormWA {
    private Long contactId;
    private String areaCode;
    private String number;
    private String extension;
    private String type;

    public CreateFormWA() {

    }

    public Long getContactId() { return contactId; }

    public void setContactId(Long contactId) { this.contactId = contactId; }

    public String getAreaCode() { return areaCode; }

    public void setAreaCode(String areaCode) { this.areaCode = areaCode; }

    public String getNumber() { return number; }

    public void setNumber(String number) { this.number = number; }

    public String getExtension() { return extension; }

    public void setExtension(String extension) { this.extension = extension; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

}
