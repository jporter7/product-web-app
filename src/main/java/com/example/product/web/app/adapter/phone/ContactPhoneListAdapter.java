package com.example.product.web.app.adapter.phone;

import com.kleancierge.product.api.repository.entity.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class ContactPhoneListAdapter {
    public List<Phone> toContract(Pageable pageable) {
        List<Phone> phoneList = new ArrayList<>();
        Page<Phone> phones = new PageImpl<Phone>(phoneList, pageable, pageable.getPageSize());
        phones.forEach(phone -> phoneList.add(phone));
        return phoneList;
    }
}
