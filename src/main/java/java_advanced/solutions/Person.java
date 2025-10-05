package java_advanced.solutions;


import java.util.Objects;
import java.util.Optional;

public record Person(String name, int age, Optional<ContactDetails> contact) implements Contact {
    public Person {
        name = Objects.requireNonNull(name, "name");
        contact = Objects.requireNonNull(contact, "contact");
    }
}

