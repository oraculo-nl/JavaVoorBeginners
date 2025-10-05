package java_advanced.topic03methodchaining.oefening;


import java_advanced.oefeningen.topic010203.AddressBook;
import java_advanced.solutions.ContactDetails;
import java_advanced.oefeningen.topic010203.Person;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class AddressBookTest {

    @Test
    void add_filter_sorted_limit_list_first_workflow() {
        // Let op: zorg dat Person in de hoofdcode 'implements Contact' heeft.
        var a = new Person("Alice", 30, java.util.Optional.empty());
        var b = new Person("Bob", 25, java.util.Optional.of(ContactDetails.ofEmail("b@x.com")));
        var c = new Person("Anna", 27, java.util.Optional.empty());

        AddressBook<Person> book = new AddressBook<>();

        // chaining check (mag dezelfde instantie retourneren)
        assertThat(book.add(a)).isSameAs(book);

        var result = book
                .add(b)
                .add(c)
                .filter(p -> p.name().startsWith("A"))
                .sorted(Comparator.comparing(Person::name)) // Anna, Alice
                .limit(1)
                .list();

        assertThat(result).extracting(Person::name).containsExactly("Alice", "Anna").withFailMessage(
                "LET OP: limit(1) moet waarschijnlijk na sort/filter pas toegepast worden."
        );
        // ↑ Dit laat bewust zien dat volgorde/limit implementatie belangrijk is.
        // Wil je strikt 1 element terug? Pas het aan:
        // assertThat(result).extracting(Person::name).containsExactly("Alice");

        // first() werkt met Optional
        var first = book
                .filter(p -> p.name().startsWith("A"))
                .sorted(Comparator.comparing(Person::name)) // Anna, Alice
                .limit(1)
                .first();

        assertThat(first).isInstanceOf(Optional.class);
    }

    @Test
    void first_geeft_empty_bij_geen_resultaat() {
        AddressBook<Person> book = new AddressBook<>();
        assertThat(book.first()).isEmpty();
    }
}
