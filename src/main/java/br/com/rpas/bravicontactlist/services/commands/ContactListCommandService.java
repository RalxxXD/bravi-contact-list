package br.com.rpas.bravicontactlist.services.commands;


import br.com.rpas.bravicontactlist.entities.Contact;
import br.com.rpas.bravicontactlist.entities.Person;
import br.com.rpas.bravicontactlist.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ContactListCommandService {

    Person updatePersonName(String personName, String newPersonName) throws ResourceNotFoundException;

    Person save(Person person);

    void deletePerson(String personName) throws ResourceNotFoundException;

    void deleteContact(String personName, String contactName) throws ResourceNotFoundException;

    Person addNewContact(String personName, List<Contact> contact) throws ResourceNotFoundException;

}
