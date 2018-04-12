package com.example.product.web.app.adapter.contact;

import com.example.product.web.app.model.contact.ModelWA;
import com.kleancierge.product.api.model.contact.CreateForm;
import com.kleancierge.product.api.model.contact.UpdateForm;
import com.kleancierge.product.api.repository.entity.Contact;

public class UpdateContactAdapter {
    public ModelWA toWebApp(UpdateForm updateForm){
        ModelWA model = new ModelWA();
        model.setEmailAddress(updateForm.getEmailAddress());
        model.setNote(updateForm.getNote());
        model.setLastName(updateForm.getLastName());
        model.setFirstName(updateForm.getFirstName());
        return model;
    }

    public Contact toContract(ModelWA model){
        Contact contact = new Contact();
        contact.setEmailAddress(model.getEmailAddress());
        contact.setNote(model.getNote());
        contact.setLastName(model.getLastName());
        contact.setFirstName(model.getFirstName());
        return contact;
    }
}
