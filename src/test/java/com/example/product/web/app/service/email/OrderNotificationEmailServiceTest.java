package com.example.product.web.app.service.email;

import com.example.product.web.app.model.email.EmailForm;
import com.kleancierge.product.api.contract.FieldErrors;
import com.kleancierge.product.api.contract.Result;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.*;

public class OrderNotificationEmailServiceTest {
    private EmailForm emailForm;

    private OrderNotificationEmailService emailService;

    private OrderNotificationEmailService.ServiceResponse serviceResponse;

    private Result result;

    @Before
    public void setUp() {
        emailForm = new EmailForm();

        emailForm.setSubject("This is a test email");
        emailForm.setMessage("<p>This is a message in a test email</p>" +
                             "<p>It does not really tell you too much</p>");
        emailForm.setFromAddress("cspath1@ycp.edu");
        emailForm.getCcAddresses().add("cspath1@ycp.edu");

        emailService = new OrderNotificationEmailService();

        serviceResponse = new IEmailService.ServiceResponse() {
            @Override
            public void success() {
                result = Result.SUCCESS(null);
            }

            @Override
            public void errors(FieldErrors fieldErrors) {
                result = Result.ERROR(fieldErrors);
            }
        };

    }

    @Test
    public void testValidConstraints_Success() {
        //Call the execute method with our valid constraints
        emailService.execute(emailForm, serviceResponse);

        //The Result object should have a null FieldErrors object
        assertNull(result.getFieldErrors());

        //The Result object should not have anything in the data class since we don't want to
        //respond with anything on success
        assertNull(result.getData());

        //The Result object should also have a status of OK
        assertEquals(HttpStatus.OK.value(), result.getStatus());

    }

    @Test
    public void testBlankSubject_Failure() {
        //Set the email form subject to be blank
        emailForm.setSubject("");

        //Now call the service with the invalid constraint
        emailService.execute(emailForm, serviceResponse);

        //The Result object should have a FieldErrors object of size 1
        assertEquals(1, result.getFieldErrors().getErrors().size());
        assertEquals(1, result.getFieldErrors().getErrors().get("Subject").size());

        //The Result object should have a null result object
        assertNull(result.getData());

        //The Result object should also have a status of BAD_REQUEST
        assertEquals(HttpStatus.BAD_REQUEST.value(), result.getStatus());
    }

    @Test
    public void testNullSubject_Failure() {
        //Set the email form subject to be null
        emailForm.setSubject(null);

        //Now call the service with the invalid constraint
        emailService.execute(emailForm, serviceResponse);

        //The Result object should have a FieldErrors object of size 1
        assertEquals(1, result.getFieldErrors().getErrors().size());
        assertEquals(1, result.getFieldErrors().getErrors().get("Subject").size());

        //The Result object should have a null result object
        assertNull(result.getData());

        //The Result object should also have a status of BAD_REQUEST
        assertEquals(HttpStatus.BAD_REQUEST.value(), result.getStatus());
    }

    @Test
    public void testBlankFromAddress_Failure() {
        //Set the email form from address to be blank
        emailForm.setFromAddress("");

        //Now call the service with the invalid constraint
        emailService.execute(emailForm, serviceResponse);

        //The Result object should have a FieldErrors object of size 1
        assertEquals(1, result.getFieldErrors().getErrors().size());
        assertEquals(1, result.getFieldErrors().getErrors().get("From Address").size());

        //The Result object should have a null result object
        assertNull(result.getData());

        //The Result object should also have a status of BAD_REQUEST
        assertEquals(HttpStatus.BAD_REQUEST.value(), result.getStatus());
    }

    @Test
    public void testNullFromAddress_Failure() {
        //Set the email form from address to be blank
        emailForm.setFromAddress(null);

        //Now call the service with the invalid constraint
        emailService.execute(emailForm, serviceResponse);

        //The Result object should have a FieldErrors object of size 1
        assertEquals(1, result.getFieldErrors().getErrors().size());
        assertEquals(1, result.getFieldErrors().getErrors().get("From Address").size());

        //The Result object should have a null result object
        assertNull(result.getData());

        //The Result object should also have a status of BAD_REQUEST
        assertEquals(HttpStatus.BAD_REQUEST.value(), result.getStatus());
    }

    @Test
    public void testInvalidFromAddress_Failure() {
        //set the email form from address to be something that is not an email
        emailForm.setFromAddress("efuihefui");

        //Now call the service with the invalid constraint
        emailService.execute(emailForm, serviceResponse);

        //The Result object should have a FieldErrors object of size 1
        assertEquals(1, result.getFieldErrors().getErrors().size());
        assertEquals(1, result.getFieldErrors().getErrors().get("From Address").size());

        //The Result object should have a null result object
        assertNull(result.getData());

        //The Result object should also have a status of BAD_REQUEST
        assertEquals(HttpStatus.BAD_REQUEST.value(), result.getStatus());
    }

    @Test
    public void testEmptyToAddresses_Failure() {
        //Remove the only CC Address we have in the email form's list
        emailForm.getCcAddresses().remove("cspath1@ycp.edu");

        //Now call the service with the invalid constraint
        emailService.execute(emailForm, serviceResponse);

        //The Result object should have a FieldErrors object of size 1
        assertEquals(1, result.getFieldErrors().getErrors().size());
        assertEquals(1, result.getFieldErrors().getErrors().get("CC Addresses").size());

        //The Result object should have a null result object
        assertNull(result.getData());

        //The Result object should also have a status of BAD_REQUEST
        assertEquals(HttpStatus.BAD_REQUEST.value(), result.getStatus());
    }

    @Test
    public void testBlankCCAddress_Failure() {
        //Add a blank address to the cc address list
        emailForm.getCcAddresses().add("");

        //Now call the service with the invalid constraint
        emailService.execute(emailForm, serviceResponse);

        //The Result object should have a FieldErrors object of size 1
        assertEquals(1, result.getFieldErrors().getErrors().size());
        assertEquals(1, result.getFieldErrors().getErrors().get("CC Addresses").size());

        //The Result object should have a null result object
        assertNull(result.getData());

        //The Result object should also have a status of BAD_REQUEST
        assertEquals(HttpStatus.BAD_REQUEST.value(), result.getStatus());
    }

    @Test
    public void testNullCCAddress_Failure() {
        //add a null address to the cc address list
        emailForm.getCcAddresses().add(null);

        //Now call the service with the invalid constraint
        emailService.execute(emailForm, serviceResponse);

        //The Result object should have a FieldErrors object of size 1
        assertEquals(1, result.getFieldErrors().getErrors().size());
        assertEquals(1, result.getFieldErrors().getErrors().get("CC Addresses").size());

        //The Result object should have a null result object
        assertNull(result.getData());

        //The Result object should also have a status of BAD_REQUEST
        assertEquals(HttpStatus.BAD_REQUEST.value(), result.getStatus());
    }

    @Test
    public void testBlankMessage_Failure() {
        //set the message to be blank
        emailForm.setMessage("");

        //Now call the service with the invalid constraint
        emailService.execute(emailForm, serviceResponse);

        //The Result object should have a FieldErrors object of size 1
        assertEquals(1, result.getFieldErrors().getErrors().size());
        assertEquals(1, result.getFieldErrors().getErrors().get("Message").size());

        //The Result object should have a null result object
        assertNull(result.getData());

        //The Result object should also have a status of BAD_REQUEST
        assertEquals(HttpStatus.BAD_REQUEST.value(), result.getStatus());
    }

    @Test
    public void testNullMessage_Failure() {
        //set the message to be null
        emailForm.setMessage(null);

        //Now call the service with the invalid constraint
        emailService.execute(emailForm, serviceResponse);

        //The Result object should have a FieldErrors object of size 1
        assertEquals(1, result.getFieldErrors().getErrors().size());
        assertEquals(1, result.getFieldErrors().getErrors().get("Message").size());

        //The Result object should have a null result object
        assertNull(result.getData());

        //The Result object should also have a status of BAD_REQUEST
        assertEquals(HttpStatus.BAD_REQUEST.value(), result.getStatus());
    }

}