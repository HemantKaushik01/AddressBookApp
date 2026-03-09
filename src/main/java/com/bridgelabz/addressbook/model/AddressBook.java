package com.bridgelabz.addressbook.model;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    private List<Contact> contactList = new ArrayList<>();

    // Add contact to the list
    public void addContact(Contact contact) {
        contactList.add(contact);
        System.out.println("Contact added successfully: " + contact);
    }

    // Display all contacts
    public void displayAllContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("All Contacts:");
            contactList.forEach(System.out::println);
        }
    }

    // Getter
    public List<Contact> getContactList() {
        return contactList;
    }
}