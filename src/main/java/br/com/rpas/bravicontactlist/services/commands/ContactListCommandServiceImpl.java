package br.com.rpas.bravicontactlist.services.commands;


import br.com.rpas.bravicontactlist.entities.Contact;
import br.com.rpas.bravicontactlist.entities.Person;
import br.com.rpas.bravicontactlist.exceptions.ResourceNotFoundException;
import br.com.rpas.bravicontactlist.repositories.ContactRepository;
import br.com.rpas.bravicontactlist.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactListCommandServiceImpl implements ContactListCommandService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ContactRepository contactRepository;

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person addNewContact(String personName, List<Contact> contacts) throws ResourceNotFoundException {
        Person person = personRepository.findByName(personName)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found " + personName));
        for (Contact contact : contacts) {
            person.addContact(new Contact(contact.getValue(), contact.getType(), person.getId()));
        }
        return personRepository.save(person);
    }

    @Override
    public Person updatePersonName(String personName, String newPersonName) throws ResourceNotFoundException {
        Person oldPerson = personRepository.findByName(personName)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found " + personName));
        Person newPerson = new Person(oldPerson.getId(), newPersonName, oldPerson.getContactList());
        return personRepository.save(newPerson);
    }

    @Override
    public void deletePerson(String personName) throws ResourceNotFoundException {
        Person person = personRepository.findByName(personName)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found " + personName));
        personRepository.delete(person);
    }

    @Override
    public void deleteContact(String personName, String contactType) throws ResourceNotFoundException {
        Person person = personRepository.findByName(personName)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found " + personName));
        Contact contact = contactRepository.findBytypeAndPersonId(contactType, person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found " + contactType));
        contactRepository.delete(contact);
    }

}
