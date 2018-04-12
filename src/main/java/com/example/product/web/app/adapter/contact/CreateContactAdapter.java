package com.example.product.web.app.adapter.contact;

import com.kleancierge.product.api.contract.contact.ContactCreateService;
import com.kleancierge.product.api.model.contact.CreateForm;
import com.kleancierge.product.api.model.contact.Model;
import com.kleancierge.product.api.repository.entity.Contact;

public class CreateContactAdapter {

    public Model toWebApp(CreateForm createForm){
        Model model = new Model();
        model.setEmailAddress(createForm.getEmailAddress());
        model.setNote(createForm.getNote());
        model.setLastName(createForm.getLastName());
        model.setFirstName(createForm.getFirstName());
        return model;
    }

    public Contact toContract(Model model){
        Contact contact = new Contact();
        model.setEmailAddress(contact.getEmailAddress());
        model.setNote(contact.getNote());
        model.setId(contact.getId());
        model.setLastName(contact.getLastName());
        model.setFirstName(contact.getFirstName());
        return contact;
    }
}
