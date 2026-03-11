package com.bridgelabz.addressbook.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
	// Edit contact by first name
	public void editContact(String firstName, Scanner scanner) {
	    boolean found = false;

	    for (Contact contact : contactList) {
	        if (contact.getFirstName().equalsIgnoreCase(firstName)) {
	            found = true;
	            System.out.println("Contact found: " + contact);
	            System.out.println("Enter new details:");

	            System.out.print("Enter new Last Name: ");
	            contact.setLastName(scanner.nextLine());

	            System.out.print("Enter new Address: ");
	            contact.setAddress(scanner.nextLine());

	            System.out.print("Enter new City: ");
	            contact.setCity(scanner.nextLine());

	            System.out.print("Enter new State: ");
	            contact.setState(scanner.nextLine());

	            System.out.print("Enter new Zip: ");
	            contact.setZip(scanner.nextLine());

	            System.out.print("Enter new Phone Number: ");
	            contact.setPhoneNumber(scanner.nextLine());

	            System.out.print("Enter new Email: ");
	            contact.setEmail(scanner.nextLine());

	            System.out.println("Contact updated successfully: " + contact);
	            break;
	        }
	    }

	    if (!found) {
	        System.out.println("Contact with name " + firstName + " not found.");
	    }
	}

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