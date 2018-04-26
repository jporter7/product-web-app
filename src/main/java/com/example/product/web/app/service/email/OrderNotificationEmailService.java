package com.example.product.web.app.service.email;

import com.example.product.web.app.model.email.EmailForm;
import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.utility.validation.EmailValidator;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * Concrete implementation of the {@link IEmailService} interface meant specifically for sending
 * notifications when a product is purchased
 */
@Service
public class OrderNotificationEmailService implements IEmailService {

    /**
     * Public Constructor
     */
    public OrderNotificationEmailService() {}

    /**
     * Concrete implementation of the {@link IEmailService} execute method. If all validation passes,
     * attempt to send the email using a {@link MimeMessage} and assigning the {@link EmailForm} values to
     * it.
     * @param emailForm the {@link EmailForm}
     * @param serviceResponse the {@link ServiceResponse} interface
     */
    @Override
    public void execute(EmailForm emailForm, ServiceResponse serviceResponse) {
        FieldErrors fieldErrors = new FieldErrors();

        if (emailForm != null) {
            fieldErrors = validate(emailForm);

            if (!fieldErrors.getErrors().isEmpty()) {
                serviceResponse.errors(fieldErrors);
            } else {
                Properties properties = System.getProperties();
                properties.setProperty("mail.smtp.host", "localhost");
                Session session = Session.getDefaultInstance(properties);

                try {
                    MimeMessage message = new MimeMessage(session);

                    message.setFrom(new InternetAddress(emailForm.getFromAddress()));

                    message.setRecipients(Message.RecipientType.TO, emailForm.getFromAddress());

                    message.setSubject(emailForm.getSubject());

                    message.setContent(emailForm.getMessage(), "text/html");

                    //Transport.send(message);

                    System.out.println("Subject: " + message.getSubject());

                    try {
                        System.out.println("Body: " + message.getContent().toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } catch (MessagingException e) {
                    e.printStackTrace();
                }

                serviceResponse.success();
            }


        } else {
            fieldErrors.getErrors().put("Form", Collections.singletonList("Error: Form is null"));
            serviceResponse.errors(fieldErrors);
        }
    }

    /**
     * Used to call all field-specific errors and aggregate a {@link FieldErrors} object of errors
     *
     * @param emailForm the {@link EmailForm}
     * @return a {@link FieldErrors} object of errors
     */
    private FieldErrors validate(EmailForm emailForm) {
        FieldErrors fieldErrors = new FieldErrors();

        List<String> fromErrors = validateFromAddress(emailForm);
        if (!fromErrors.isEmpty()) {
            fieldErrors.getErrors().put("From Address", fromErrors);
        }
        List<String> ccErrors = validateCcAddresses(emailForm);
        if (!ccErrors.isEmpty()) {
            fieldErrors.getErrors().put("CC Addresses", ccErrors);
        }
        List<String> subjectErrors = validateSubject(emailForm);
        if (!subjectErrors.isEmpty()) {
            fieldErrors.getErrors().put("Subject", subjectErrors);
        }
        List<String> messageErrors = validateMessage(emailForm);
        if (!messageErrors.isEmpty()) {
            fieldErrors.getErrors().put("Message", messageErrors);
        }

        return fieldErrors;
    }

    /**
     * Used to make sure the {@link EmailForm} from address is not null or blank and is a
     * valid email address
     *
     * @param emailForm the {@link EmailForm}
     * @return a {@link List<String>} of errors
     */
    private List<String> validateFromAddress(EmailForm emailForm) {
        List<String> errors = new ArrayList<>();
        if (emailForm.getFromAddress() == null || emailForm.getFromAddress().trim().equals("")) {
            errors.add("From email address cannot be blank");
        } else if (!EmailValidator.validateEmail(emailForm.getFromAddress()).isEmpty()) {
            errors.add(String.format("%s is not a valid email address", emailForm.getFromAddress()));
        }

        return errors;
    }

    /**
     * Used to make sure the {@link EmailForm} ccAddresses are all valid email addresses
     *
     * @param emailForm the {@link EmailForm}
     * @return a {@link List<String>} of errors
     */
    private List<String> validateCcAddresses(EmailForm emailForm) {
        List<String> errors = new ArrayList<>();
        if (emailForm.getCcAddresses().isEmpty()) {
            errors.add("No CC addresses were specified");
            return errors;
        }
        emailForm.getCcAddresses().forEach(s -> {
            if (s == null || s.trim().equals("")) {
                errors.add("Email address cannot be blank");
            } else if (!EmailValidator.validateEmail(s).isEmpty()) {
                errors.add(String.format("%s is not a valid email address", s));
            }
        });

        return errors;
    }

    /**
     * Used to make sure the {@link EmailForm} subject is not null or blank
     *
     * @param emailForm the {@link EmailForm}
     * @return a {@link List<String>} of errors
     */
    private List<String> validateSubject(EmailForm emailForm) {
        List<String> errors = new ArrayList<>();
        if (emailForm.getSubject() == null || emailForm.getSubject().trim().equals("")) {
            errors.add("Email subject cannot be blank");
        }

        return errors;
    }

    /**
     * Used to make sure the {@link EmailForm} message is not null or blank
     *
     * @param emailForm the {@link EmailForm}
     * @return a {@link List<String>} of errors
     */
    private List<String> validateMessage(EmailForm emailForm) {
        List<String> errors = new ArrayList<>();
        if (emailForm.getMessage() == null || emailForm.getMessage().trim().equals("")) {
            errors.add("Email content cannot be blank");
        }

        return errors;
    }
}
