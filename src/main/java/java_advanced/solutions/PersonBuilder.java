package java_advanced.solutions;


import java.util.Optional;

public class PersonBuilder {
    private String name;
    private int age;
    private Optional<String> email = Optional.empty();
    private Optional<String> phone = Optional.empty();

    public PersonBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder age(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder email(String email) {
        this.email = Optional.ofNullable(email);
        return this;
    }

    public PersonBuilder phone(String phone) {
        this.phone = Optional.ofNullable(phone);
        return this;
    }

    public Person build() {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name is required");
        }
        if (age < 0) {
            throw new IllegalArgumentException("age must be >= 0");
        }
        Optional<ContactDetails> contact =
                (email.isPresent() || phone.isPresent())
                        ? Optional.of(new ContactDetails(email, phone))
                        : Optional.empty();

        return new Person(name, age, contact);
    }
}

