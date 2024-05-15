package microservices.demo.contact.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import microservices.demo.contact.model.Contact;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    Optional<Contact> findById(Long id);

    Optional<Contact> findByEmail(String email);
}
