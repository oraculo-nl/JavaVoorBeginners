package java_advanced.oefeningen.topic010203;

import java_advanced.solutions.ContactDetails;

import java.util.Optional;

public record Person(String name, int age, Optional<ContactDetails> contact) {
}
