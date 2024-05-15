package microservices.demo.contact.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import microservices.demo.contact.model.Contact;

@Repository
@RequiredArgsConstructor
public class ContactDaoImpl implements ContactDao {

    private final ContactRepository contactRepository;

    @Override
    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Optional<Contact> getContact(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public Optional<Contact> getContactByEmail(String email) {
        return contactRepository.findByEmail(email);
    }

}
