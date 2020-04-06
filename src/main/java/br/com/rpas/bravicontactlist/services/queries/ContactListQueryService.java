package br.com.rpas.bravicontactlist.services.queries;



import br.com.rpas.bravicontactlist.entities.Person;

import java.util.List;
import java.util.Optional;

public interface ContactListQueryService {

    List<Person> findAll();

    Optional<Person> findByName(String name);

}
