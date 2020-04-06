package br.com.rpas.bravicontactlist.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "person_id")
    private List<Contact> contactList;

    public Person(){}

    public Person(String name, List<Contact> contactList) {
        this.name = name;
        this.contactList = contactList;
    }

    public Person(Long id, String name, List<Contact> contactList) {
        this.id = id;
        this.name = name;
        this.contactList = contactList;
    }

    public Person(String name) {
        this.name = name;
        this.contactList = new ArrayList<Contact>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void addContact(Contact contact) {
        contactList.add(contact);
    }
}
