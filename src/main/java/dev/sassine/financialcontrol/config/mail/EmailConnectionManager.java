package dev.sassine.financialcontrol.config.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

@Component
public class EmailConnectionManager {

    private final EmailConfig emailConfig;

    @Autowired
    public EmailConnectionManager(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }

    public Store createStore() throws MessagingException {
        Session emailSession = Session.getInstance(emailConfig.toProperties());
        Store store = emailSession.getStore(emailConfig.getProtocol());
        store.connect(emailConfig.getHost(), emailConfig.getUsername(), emailConfig.getPassword());
        return store;
    }
}



