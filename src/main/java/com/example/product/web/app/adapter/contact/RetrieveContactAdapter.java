package com.example.product.web.app.adapter.contact;

import com.example.product.web.app.model.contact.ModelWA;
import com.kleancierge.product.api.repository.entity.Contact;

public class RetrieveContactAdapter {
    public Contact toContract(ModelWA model){
        Contact contact = new Contact();
        contact.setEmailAddress(model.getEmailAddress());
        contact.setNote(model.getNote());
        contact.setLastName(model.getLastName());
        contact.setFirstName(model.getFirstName());
        return contact;
    }
}
