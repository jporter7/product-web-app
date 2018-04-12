package com.example.product.web.app.model.contact;

import com.kleancierge.product.api.repository.entity.Contact;

/**
 * @property id - the Contact's id
 * @property firstName - the Contact's first name
 * @property lastName - the Contact's last name
 * @property emailAddress - the Contact's email address
 * @property note - the Contact's note
 */
public class ModelWA {
    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String note;

    public ModelWA() {

    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmailAddress() { return emailAddress; }

    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }

    public String getNote() { return note; }

    public void setNote(String note) { this.note = note; }
}
