package br.com.rpas.bravicontactlist.services.queries;


import br.com.rpas.bravicontactlist.entities.Person;

import br.com.rpas.bravicontactlist.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactListQueryServiceImpl implements ContactListQueryService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> findByName(String name) {
        return personRepository.findByName(name);
    }
}
