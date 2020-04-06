package br.com.rpas.bravicontactlist.controllers;

import br.com.rpas.bravicontactlist.entities.Contact;
import br.com.rpas.bravicontactlist.entities.Person;
import br.com.rpas.bravicontactlist.exceptions.ResourceNotFoundException;
import br.com.rpas.bravicontactlist.services.commands.ContactListCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/contactList")
public class ContactListCommandController {

    @Autowired
    ContactListCommandService contactListCommandService;

    @PostMapping("/person/")
    public ResponseEntity createPerson(@RequestBody Person person)  {
        return  ResponseEntity.status(HttpStatus.CREATED).body(contactListCommandService.save(person));
    }

    @PostMapping("/contact/")
    public ResponseEntity addNewContact(@PathParam(value = "personName") String personName
            , @RequestBody List<Contact> contacts) throws ResourceNotFoundException {
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(contactListCommandService.addNewContact(personName, contacts));
    }

    @PatchMapping("/person/")
    public ResponseEntity updatePersonName(@PathParam(value = "personName") String personName
        ,@PathParam(value = "newPersonName") String newPersonName) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(contactListCommandService.updatePersonName(personName, newPersonName));
    }

    @DeleteMapping("/person/")
    public ResponseEntity deletePerson(@PathParam(value = "personName") String personName)
            throws ResourceNotFoundException {
        contactListCommandService.deletePerson(personName);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/contact/")
    public ResponseEntity deleteContact(@PathParam(value = "personName") String personName
            , @PathParam(value = "contactType") String contactType) throws ResourceNotFoundException {
        contactListCommandService.deleteContact(personName, contactType);
        return ResponseEntity.ok().build();
    }
}
