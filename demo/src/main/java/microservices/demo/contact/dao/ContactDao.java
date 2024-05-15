package microservices.demo.contact.dao;

import java.util.List;
import java.util.Optional;

import microservices.demo.contact.model.Contact;

public interface ContactDao {

    void saveContact(Contact contact);

    Optional<Contact> getContact(Long id);

    List<Contact> getAllContacts();

    Optional<Contact> getContactByEmail(String email);
}
