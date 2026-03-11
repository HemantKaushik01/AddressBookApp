package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.model.Contact;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddressBookService {

    private List<Contact> contactList = new ArrayList<>();
    private int idCounter = 1;

    // Get all contacts
    @Override
    public List<Contact> getAllContacts() {
        return contactList;
    }

    // Get contact by ID
    @Override
    public Contact getContactById(int id) {
        Optional<Contact> contact = contactList.stream()
            .filter(c -> c.getId() == id)
            .findFirst();
        return contact.orElse(null);
    }

    // Add new contact
    @Override
    public Contact addContact(Contact contact) {
        contact.setId(idCounter++);
        contactList.add(contact);
        return contact;
    }

    // Update contact by ID
    @Override
    public Contact updateContact(int id, Contact updatedContact) {
        for (Contact contact : contactList) {
            if (contact.getId() == id) {
                contact.setFirstName(updatedContact.getFirstName());
                contact.setLastName(updatedContact.getLastName());
                contact.setAddress(updatedContact.getAddress());
                contact.setCity(updatedContact.getCity());
                contact.setState(updatedContact.getState());
                contact.setZip(updatedContact.getZip());
                contact.setPhoneNumber(updatedContact.getPhoneNumber());
                contact.setEmail(updatedContact.getEmail());
                return contact;
            }
        }
        return null;
    }

    // Delete contact by ID
    @Override
    public boolean deleteContact(int id) {
        return contactList.removeIf(c -> c.getId() == id);
    }
}