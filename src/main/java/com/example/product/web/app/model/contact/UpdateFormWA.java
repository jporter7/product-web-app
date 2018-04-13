package com.example.product.web.app.model.contact;

import com.kleancierge.product.api.repository.entity.Contact;

/**
 * Form used for update service of {@link Contact}
 *
 * @property id - the Contact's id
 * @property firstName - the desired new first name of the Contact
 * @property lastName - the desired new last name of the Contact
 * @property note - the desired new note of the Contact
 * @property emailAddress - the desired new email address of the Contact
 */
public class UpdateFormWA {

    private Long id;
    private String firstName;
    private String lastName;
    private String note;
    private String emailAddress;

    public UpdateFormWA() {

    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getNote() { return note; }

    public void setNote(String note) { this.note = note; }

    public String getEmailAddress() { return emailAddress; }

    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }

}
