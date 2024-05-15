package microservices.demo.contact.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import microservices.demo.contact.model.Contact;
import microservices.demo.contact.service.ContactService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping("/contacts/{id}")
    public Contact getContact(@PathVariable Long id) {
        return contactService.getContact(id);
    }

    @GetMapping("/contacts")
    public List<Contact> getAllContact() {
        return contactService.getAllContacts();
    }

    @PostMapping("/contacts")
    public void saveContact(@RequestBody Contact contact) {
        contactService.saveContact(contact);
    }
}
