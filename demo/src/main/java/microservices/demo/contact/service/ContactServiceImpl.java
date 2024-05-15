package microservices.demo.contact.service;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import microservices.demo.contact.dao.ContactDao;
import microservices.demo.contact.model.Contact;
import microservices.demo.exceptions.ObjectAlreadyExists;
import microservices.demo.exceptions.ObjectNotFoundException;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactDao contactDao;

    @Override
    public void saveContact(Contact contact) {
        contactDao.getContactByEmail(contact.getEmail())
                .ifPresent(c -> {
                    throw new ObjectAlreadyExists("the email " + contact.getEmail() + " already exists");
                });
        contactDao.saveContact(contact);
    }

    @Override
    public Contact getContact(Long id) {
        return contactDao.getContact(id)
                .orElseThrow(() -> new ObjectNotFoundException("Contact with id " + id + " is not found"));
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactDao.getAllContacts();
    }

    @Override
    public Contact getContactByEmail(String email) {
        return contactDao.getContactByEmail(email)
                .orElseThrow(() -> new ObjectNotFoundException("Contact with email " + email + "is not found"));
    }

}
