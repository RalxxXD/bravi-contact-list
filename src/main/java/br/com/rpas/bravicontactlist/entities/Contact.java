package br.com.rpas.bravicontactlist.entities;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contact_id")
    private Long id;
    private String value;
    private String type;
    @Column(name="person_id")
    private Long personId;

    public Contact(){}

    public Contact(String value, String type) {
        this.value = value;
        this.type = type;
    }

    public Contact(String value, String type, Long personId) {
        this.value = value;
        this.type = type;
        this.personId = personId;
    }

    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public Long getPersonId() {
        return personId;
    }

}
