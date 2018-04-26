package com.example.product.web.app.model.email;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailFormTest {
    private EmailForm emailForm;

    @Before
    public void setUp() {
        emailForm = new EmailForm();
        emailForm.setFromAddress("donotreply@kleancierge.com");
        emailForm.setMessage("this is an email message");
        emailForm.setSubject("Message");

        emailForm.getCcAddresses().add("cspath1@ycp.edu");
        emailForm.getCcAddresses().add("jporter7@ycp.edu");
        emailForm.getCcAddresses().add("vincemoley@gmail.com");
    }

    @Test
    public void testSetFromAddress() {
        assertEquals(emailForm.getFromAddress(), "donotreply@kleancierge.com");
    }

    @Test
    public void testSetMessage() {
        assertEquals(emailForm.getMessage(), "this is an email message");
    }

    @Test
    public void testSetSubject() {
        assertEquals(emailForm.getSubject(), "Message");
    }

    @Test
    public void testSetCcAddresses() {
        assertEquals(emailForm.getCcAddresses().size(), 3);
        assertTrue(emailForm.getCcAddresses().contains("cspath1@ycp.edu"));
        assertTrue(emailForm.getCcAddresses().contains("jporter7@ycp.edu"));
        assertTrue(emailForm.getCcAddresses().contains("vincemoley@gmail.com"));
    }
}