package com.bridgelabz.addressbook;

import com.bridgelabz.addressbook.model.AddressBook;
import com.bridgelabz.addressbook.model.Contact;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class AddressBookAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressBookAppApplication.class, args);

        System.out.println("Welcome to Address Book Program");

        // Create AddressBook
        AddressBook addressBook = new AddressBook();

        // Take input from console
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter City: ");
        String city = scanner.nextLine();

        System.out.print("Enter State: ");
        String state = scanner.nextLine();

        System.out.print("Enter Zip: ");
        String zip = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        // Create Contact object
        Contact contact = new Contact(
            firstName, lastName, address,
            city, state, zip,
            phoneNumber, email
        );

        // Add to Address Book
        addressBook.addContact(contact);

        // Display all contacts
        addressBook.displayAllContacts();

        scanner.close();
    }
}
