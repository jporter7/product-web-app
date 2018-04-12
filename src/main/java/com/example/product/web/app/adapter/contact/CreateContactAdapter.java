package com.example.product.web.app.adapter.contact;

import com.kleancierge.product.api.contract.contact.ContactCreateService;
import com.kleancierge.product.api.model.contact.CreateForm;
import com.kleancierge.product.api.model.contact.Model;
import com.kleancierge.product.api.repository.entity.Contact;

public class CreateContactAdapter {

    public Contact toWebApp(CreateForm createForm){
        Contact contact = new Contact();
        contact.setEmailAddress(createForm.getEmailAddress());
        contact.setNote(createForm.getNote());
        contact.setLastName(createForm.getLastName());
        contact.setFirstName(createForm.getFirstName());
        return contact;
    }

    public Model toContract(Contact contact){
        Model model = new Model();
        model.setEmailAddress(contact.getEmailAddress());
        model.setNote(contact.getNote());
        model.setId(contact.getId());
        model.setLastName(contact.getLastName());
        model.setFirstName(contact.getFirstName());
        return model;
    }
}
