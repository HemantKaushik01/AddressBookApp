package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.Contact;
import com.bridgelabz.addressbook.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    // UC 2 - GET All Contacts
    @GetMapping
    public ResponseEntity<ResponseDTO> getAllContacts() {
        List<Contact> contacts = addressBookService.getAllContacts();
        ResponseDTO response = new ResponseDTO(
            "Fetched all contacts successfully", contacts
        );
        return ResponseEntity.ok(response);
    }

    // UC 2 - GET Contact by ID
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable int id) {
        Contact contact = addressBookService.getContactById(id);
        if (contact != null) {
            ResponseDTO response = new ResponseDTO(
                "Contact found successfully", contact
            );
            return ResponseEntity.ok(response);
        }
        ResponseDTO response = new ResponseDTO(
            "Contact with id " + id + " not found", null
        );
        return ResponseEntity.status(404).body(response);
    }

    // UC 2 - POST Add Contact
    @PostMapping
    public ResponseEntity<ResponseDTO> addContact(@RequestBody Contact contact) {
        Contact savedContact = addressBookService.addContact(contact);
        ResponseDTO response = new ResponseDTO(
            "Contact added successfully", savedContact
        );
        return ResponseEntity.ok(response);
    }

    // UC 3 - PUT Update Contact by ID
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateContact(
            @PathVariable int id,
            @RequestBody Contact contact) {
        Contact updatedContact = addressBookService.updateContact(id, contact);
        if (updatedContact != null) {
            ResponseDTO response = new ResponseDTO(
                "Contact updated successfully", updatedContact
            );
            return ResponseEntity.ok(response);
        }
        ResponseDTO response = new ResponseDTO(
            "Contact with id " + id + " not found", null
        );
        return ResponseEntity.status(404).body(response);
    }

    // UC 4 - DELETE Contact by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable int id) {
        boolean deleted = addressBookService.deleteContact(id);
        if (deleted) {
            ResponseDTO response = new ResponseDTO(
                "Contact with id " + id + " deleted successfully", null
            );
            return ResponseEntity.ok(response);
        }
        ResponseDTO response = new ResponseDTO(
            "Contact with id " + id + " not found", null
        );
        return ResponseEntity.status(404).body(response);
    }
}