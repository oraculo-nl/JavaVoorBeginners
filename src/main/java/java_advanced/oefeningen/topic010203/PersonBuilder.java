package java_advanced.oefeningen.topic010203;


import java_advanced.solutions.ContactDetails;

import java.util.Optional;

public class PersonBuilder {
    private String name;
    private int age;
    private Optional<ContactDetails> contact = Optional.empty();

    public PersonBuilder name(String name) { /* this.name=...; return this; */
        return this;
    }

    public PersonBuilder age(int age) { /* TODO */
        return this;
    }

    public PersonBuilder email(String email) { /* contact = Optional.of(...); return this; */
        return this;
    }

    public PersonBuilder phone(String phone) { /* idem */
        return this;
    }

    public Person build() { /* TODO: valideer naam/age; return new Person(...); */
        return null;
    }
}
