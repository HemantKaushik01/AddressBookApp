package com.bridgelabz.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bridgelabz.addressbook.model.Contact;

@SpringBootApplication
public class AddressBookAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(AddressBookAppApplication.class, args);

        Contact contact = new Contact(
            "Hemant", "Kaushik",
            "123 Main St", "Mathura", "UP", "281001",
            "9876543210", "hemant@example.com"
        );

        System.out.println("Welcome to Address Book Program");
        System.out.println(contact);
    }
}

