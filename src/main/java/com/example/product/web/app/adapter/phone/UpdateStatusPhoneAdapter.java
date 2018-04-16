package com.example.product.web.app.adapter.phone;

import com.example.product.web.app.model.phone.ModelWA;
import com.kleancierge.product.api.repository.entity.Phone;

import java.util.Locale;

public class UpdateStatusPhoneAdapter {
    public Phone toContract(ModelWA model) {
        Phone phone = new Phone();
        phone.setAreaCode(model.getAreaCode());
        phone.setNumber(model.getNumber());
        phone.setExtension(model.getExtension());
        phone.setType(Phone.Type.valueOf(model.getType().toUpperCase(Locale.US)));
        return phone;
    }
}
