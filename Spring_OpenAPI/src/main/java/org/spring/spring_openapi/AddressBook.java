package org.spring.spring_openapi;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class AddressBook {
    HashMap<String, Contact> contactHashMap = new HashMap<>();

    @GetMapping("/{id}")
    public Contact getContact(@PathVariable String id) {
        return contactHashMap.get(id);
    }

    @GetMapping("/")
    public List<Contact> getAllContacts() {
        return new ArrayList<>(contactHashMap.values());
    }

    @PostMapping("/")
    public Contact createContact(@RequestBody Contact contact) {
        contactHashMap.put(contact.getId(), contact);
        return contact;
    }

    @PutMapping("/{id}")
    public Contact updateContact(@RequestBody Contact contact, @PathVariable String id) {
        contactHashMap.put(id, contact);
        return contact;
    }

}
