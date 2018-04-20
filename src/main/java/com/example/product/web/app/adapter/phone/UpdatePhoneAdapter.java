package com.example.product.web.app.adapter.phone;

import com.example.product.web.app.model.phone.CreateFormWA;
import com.example.product.web.app.model.phone.ModelWA;
import com.example.product.web.app.model.phone.UpdateFormWA;
import com.kleancierge.product.api.repository.entity.Phone;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

public class UpdatePhoneAdapter {
    public ModelWA toWebApp(UpdateFormWA updateForm, @RequestParam("id") Long id) {
        ModelWA model = new ModelWA();
        model.setAreaCode(updateForm.getAreaCode());
        model.setNumber(updateForm.getNumber());
        model.setExtension(updateForm.getExtension());
        model.setType(updateForm.getType().toUpperCase(Locale.US));
        model.setId(id);
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
