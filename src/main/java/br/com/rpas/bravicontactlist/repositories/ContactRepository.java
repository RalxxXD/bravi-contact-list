package br.com.rpas.bravicontactlist.repositories;


import br.com.rpas.bravicontactlist.entities.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ContactRepository extends CrudRepository<Contact, Long> {

    Optional<Contact> findBytypeAndPersonId(String type, Long personId);

}
