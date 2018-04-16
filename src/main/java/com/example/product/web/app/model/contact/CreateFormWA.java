package com.example.product.web.app.model.contact;

import com.kleancierge.product.api.repository.entity.Contact;
import com.kleancierge.product.api.repository.entity.Vendor;

/**
 * Form used for creation service of {@link Contact}
 *
 * @property vendorId - the Contact's {@link Vendor} id
 * @property firstName - the Contact's first name
 * @property lastName - the Contact's last name
 * @property note - the Contact's note detailing brief information
 * @property emailAddress - the Contact's email address
 */
public class CreateFormWA {

    private Long vendorId;
    private String firstName;
    private String lastName;
    private String note;
    private String emailAddress;

    public CreateFormWA() {

    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
