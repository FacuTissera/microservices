package microservices.demo.contact.service;

import java.util.List;

import microservices.demo.contact.model.Contact;

public interface ContactService {

    void saveContact(Contact contact);

    Contact getContact(Long id);

    List<Contact> getAllContacts();

    Contact getContactByEmail(String email);
}
