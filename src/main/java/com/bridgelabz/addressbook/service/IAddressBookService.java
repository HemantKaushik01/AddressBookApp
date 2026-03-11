package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.model.Contact;
import java.util.List;

public interface IAddressBookService {
    List<Contact> getAllContacts();
    Contact       getContactById(int id);
    Contact       addContact(Contact contact);
    Contact       updateContact(int id, Contact contact);
    boolean       deleteContact(int id);
}