package com.example.product.web.app.adapter.contact;

import com.kleancierge.product.api.repository.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class VendorContactListAdapter {
    public List<Contact> toContract(Pageable pageable){
        List<Contact> contactList = new ArrayList<>();
        Page<Contact> contacts = new PageImpl<Contact>(contactList, pageable, pageable.getPageSize());
        contacts.forEach(contact -> contactList.add(contact));
        return contactList;
    }
}
