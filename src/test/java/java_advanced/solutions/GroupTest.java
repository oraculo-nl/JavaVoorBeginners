package java_advanced.solutions;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

import static org.assertj.core.api.Assertions.*;

class GroupTest {

    /**
     * Tests voor de minimale API:
     * - add(T)
     * - size()
     * - isEmpty()
     * - get(int)
     * - clear()
     * <p>
     * Vereist in main:
     * - class Person { ... }
     * - class Student extends Person { ... }
     * - class Teacher extends Person { ... }
     * - class Group<T extends Person> { ... }
     */

    @Test
    void new_group_is_empty_and_size_zero() {
        Group<Student> klas = new Group<>();
        assertThat(klas.isEmpty()).isTrue();
        assertThat(klas.size()).isZero();
    }

    @Test
    void add_and_get_returns_same_instance() {
        Group<Student> klas = new Group<>();
        Student alice = new Student("Alice");
        klas.add(alice);

        assertThat(klas.isEmpty()).isFalse();
        assertThat(klas.size()).isEqualTo(1);

        // get(0) moet exact hetzelfde object teruggeven
        assertThat(klas.get(0)).isSameAs(alice);
        assertThat(klas.get(0).name()).isEqualTo("Alice");
    }

    @Test
    void add_null_should_throw_iae() {
        Group<Student> klas = new Group<>();
        assertThatThrownBy(() -> klas.add(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void get_out_of_bounds_should_throw() {
        Group<Student> klas = new Group<>();
        klas.add(new Student("Alice"));

        assertThatThrownBy(() -> klas.get(-1))
                .isInstanceOf(IndexOutOfBoundsException.class);
        assertThatThrownBy(() -> klas.get(1))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void clear_should_remove_all_members() {
        Group<Student> klas = new Group<>();
        klas.add(new Student("Alice"));
        klas.add(new Student("Bob"));

        klas.clear();

        assertThat(klas.size()).isZero();
        assertThat(klas.isEmpty()).isTrue();
        assertThatThrownBy(() -> klas.get(0))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void groups_are_type_safe_at_compile_time() {
        Group<Student> klas = new Group<>();
        klas.add(new Student("Alice"));

        // De volgende regel mag NIET compileren (bewijst generics type safety):
        // klas.add(new Teacher("Bob")); // <- uitcommentarieerd laten: compile error gewenst
        assertThat(klas.size()).isEqualTo(1);
    }
    @Test
    void generic_type_parameter_is_bounded_by_Person() {
        TypeVariable<Class<Group>>[] params = Group.class.getTypeParameters();
        assertThat(params)
                .as("Group should declare exactly one generic type parameter")
                .hasSize(1);

        Type[] bounds = params[0].getBounds();
        assertThat(bounds)
                .as("The single type parameter should have exactly one upper bound")
                .hasSize(1);

        assertThat(bounds[0])
                .as("The upper bound must be Person (i.e., Group<T extends Person>)")
                .isEqualTo(Person.class);
    }
}
