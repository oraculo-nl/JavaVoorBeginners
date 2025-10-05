package java_advanced.solutions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PersonTest {


    @Test
    void chaining_stelt_alle_velden_in() {
        Person p = new Person()
                .name("Alice")
                .age(30)
                .address("Main Street 1");

        assertThat(p.name()).isEqualTo("Alice");
        assertThat(p.age()).isEqualTo(30);
        assertThat(p.address()).isEqualTo("Main Street 1");
    }

    @Test
    void elke_setter_geeft_dezelfde_instance_terug_return_this() {
        Person p = new Person();

        Person afterName = p.name("Bob");
        Person afterAge = p.age(42);
        Person afterAddress = p.address("Elm 7");

        assertThat(afterName).isSameAs(p);
        assertThat(afterAge).isSameAs(p);
        assertThat(afterAddress).isSameAs(p);
    }

    @Test
    void chaining_volgorde_mag_varieren_maar_resultaat_is_consistent() {
        Person p1 = new Person().name("Cara").age(22).address("A");
        Person p2 = new Person().address("A").age(22).name("Cara");

        assertThat(p1.name()).isEqualTo(p2.name());
        assertThat(p1.age()).isEqualTo(p2.age());
        assertThat(p1.address()).isEqualTo(p2.address());
    }

    @Test
    void negative_age_geeft_fout() {
        Person p = new Person();
        assertThatThrownBy(() -> p.age(-1)).isInstanceOf(IllegalArgumentException.class);
    }
}
