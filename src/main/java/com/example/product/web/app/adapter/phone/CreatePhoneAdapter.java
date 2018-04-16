package com.example.product.web.app.adapter.phone;

import com.example.product.web.app.model.phone.CreateFormWA;
import com.example.product.web.app.model.phone.ModelWA;
import com.kleancierge.product.api.repository.entity.Phone;

import java.util.Locale;

public class CreatePhoneAdapter {
    public ModelWA toWebApp(CreateFormWA createForm) {
        ModelWA model = new ModelWA();
        model.setAreaCode(createForm.getAreaCode());
        model.setNumber(createForm.getNumber());
        model.setExtension(createForm.getExtension());
        model.setType(createForm.getType().toUpperCase(Locale.US));
        return model;
    }

    public Phone toContract(ModelWA model) {
        Phone phone = new Phone();
        phone.setAreaCode(model.getAreaCode());
        phone.setNumber(model.getNumber());
        phone.setExtension(model.getExtension());
        phone.setType(Phone.Type.valueOf(model.getType().toUpperCase(Locale.US)));
        return phone;
    }
}
