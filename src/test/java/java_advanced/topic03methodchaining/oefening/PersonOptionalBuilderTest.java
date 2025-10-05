package java_advanced.topic03methodchaining.oefening;


import java_advanced.solutions.ContactDetails;
import java_advanced.oefeningen.topic010203.Person;
import java_advanced.oefeningen.topic010203.PersonBuilder;
import java_advanced.oefeningen.topic010203.PersonUtils;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class PersonOptionalBuilderTest {

    @Test
    void builder_stelt_velden_in_en_chainet() {
        Person p = new PersonBuilder()
                .name("Alice")
                .age(30)
                .email("alice@example.com")
                .build();

        assertThat(p.name()).isEqualTo("Alice");
        assertThat(p.age()).isEqualTo(30);
        assertThat(p.contact()).isPresent();
        assertThat(p.contact().flatMap(ContactDetails::email)).contains("alice@example.com");
    }

    @Test
    void primaryContact_kiest_eerst_email_dan_phone_anders_leeg() {
        Person metEmail = new PersonBuilder()
                .name("Bob").age(25)
                .email("bob@mail.com")
                .build();

        Person metPhone = new PersonBuilder()
                .name("Cara").age(28)
                .phone("06-123")
                .build();

        Person geenContact = new PersonBuilder()
                .name("Dave").age(40)
                .build();

        assertThat(PersonUtils.primaryContact(metEmail)).contains("bob@mail.com");
        assertThat(PersonUtils.primaryContact(metPhone)).contains("06-123");
        assertThat(PersonUtils.primaryContact(geenContact)).isEmpty();
    }

    @Test
    void contactLabel_formatteert_mooi() {
        Person p1 = new PersonBuilder()
                .name("Eve").age(35)
                .email("eve@ex.com")
                .build();

        Person p2 = new PersonBuilder()
                .name("Finn").age(20)
                .phone("06-999")
                .build();

        Person p3 = new PersonBuilder()
                .name("Gus").age(22)
                .build();

        assertThat(PersonUtils.contactLabel(p1)).isEqualTo("Eve (email: eve@ex.com)");
        assertThat(PersonUtils.contactLabel(p2)).isEqualTo("Finn (phone: 06-999)");
        assertThat(PersonUtils.contactLabel(p3)).isEqualTo("Gus (no contact)");
    }

    @Test
    void person_record_blijft_optional_gericht() {
        // Verifieer dat Optional velden niet null zijn in de record
        Person p = new Person("Hank", 33, Optional.empty());
        assertThat(p.contact()).isNotNull();
        assertThat(p.contact()).isEmpty();
    }
}
