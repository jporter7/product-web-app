package com.example.product.web.app.model.email;

import java.util.ArrayList;
import java.util.List;

public class EmailForm {
    private String fromAddress;
    private List<String> ccAddresses = new ArrayList<>();
    private String subject;
    private String message;


    public String getFromAddress() { return fromAddress; }

    public void setFromAddress(String fromAddress) { this.fromAddress = fromAddress; }

    public List<String> getCcAddresses() { return ccAddresses; }

    public String getSubject() { return subject; }

    public void setSubject(String subject) { this.subject = subject; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }
}
