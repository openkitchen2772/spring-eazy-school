package com.eazybytes.eazyschool.services;

import com.eazybytes.eazyschool.models.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private static Logger log = LoggerFactory.getLogger(ContactService.class);

    public boolean saveMessage(Contact contact) {
        boolean isSaved = true;
        log.info(contact.toString());
        return isSaved;
    }

}
