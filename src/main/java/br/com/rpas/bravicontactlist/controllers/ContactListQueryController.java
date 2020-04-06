package br.com.rpas.bravicontactlist.controllers;

import br.com.rpas.bravicontactlist.entities.Person;
import br.com.rpas.bravicontactlist.exceptions.ResourceNotFoundException;
import br.com.rpas.bravicontactlist.services.queries.ContactListQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/contactList")
public class ContactListQueryController {

    @Autowired
    ContactListQueryService contactListQueryService;

    @GetMapping
    public ResponseEntity<List<Person>> findAll(){
        return ResponseEntity.ok().body(contactListQueryService.findAll());
    }

    @GetMapping("/findBy/")
    public ResponseEntity<Person> findByName(@PathParam("name") String name) throws ResourceNotFoundException {

        Person person = contactListQueryService.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found " + name));

        return ResponseEntity.ok().body(person);
    }

}
