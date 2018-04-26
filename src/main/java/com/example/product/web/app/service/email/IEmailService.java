package com.example.product.web.app.service.email;

import com.example.product.web.app.model.email.EmailForm;
import com.kleancierge.product.api.contract.FieldErrors;

/**
 * Interface used for creating and sending emails
 */
public interface IEmailService {
    /**
     * Execute method intended for email transmission
     *
     * @param emailForm the {@link EmailForm}
     * @param serviceResponse the {@link ServiceResponse} interface
     */
    void execute(EmailForm emailForm, ServiceResponse serviceResponse);

    /**
     * Interface with two methods:
     *
     * 1.) success -> On-Success callback that does not take any parameters
     * 2.) errors -> On-Failure callback that takes a {@link FieldErrors} object
     */
    interface ServiceResponse {
        void success();
        void errors(FieldErrors fieldErrors);
    }
}


