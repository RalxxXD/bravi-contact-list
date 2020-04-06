package br.com.rpas.bravicontactlist.repositories;



import br.com.rpas.bravicontactlist.entities.Person;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findAll();

    Optional<Person> findByName(String name);

}
