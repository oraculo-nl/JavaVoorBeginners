package java_advanced.solutions;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class ClassRoomTest {

    private Student s(String id, String name, String email) {
        return new Student()
                .id(id)
                .name(name)
                .email(email);
    }

    @Test
    void student_chaining_werkt_en_grade_is_weg() {
        Student st = new Student()
                .id("s1")
                .name("Alice")
                .email("alice@school.nl");

        assertThat(st.getId()).isEqualTo("s1");
        assertThat(st.getName()).isEqualTo("Alice");
        assertThat(st.getEmail()).isEqualTo("alice@school.nl");

        // Deze test is informatief: er mag geen grade meer bestaan.
        // (Niet aan te passen: als er nog grade-API bestaat, faalt je compile of andere tests.)
    }

    @Test
    void classroom_add_en_addAll_negeren_nulls() {
        ClassRoom cr = new ClassRoom("INF1", null);

        cr.add(null);
        assertThat(cr.getStudents()).isEmpty();

        List<Student> init = new ArrayList<>();
        init.add(s("s1", "Alice", "a@x.nl"));
        init.add(null);
        init.add(s("s2", "Bob", null));

        cr.addAll(init);
        assertThat(cr.getStudents()).hasSize(2);
        assertThat(cr.getStudents().get(0).getId()).isEqualTo("s1");
        assertThat(cr.getStudents().get(1).getId()).isEqualTo("s2");
    }

    @Test
    void classroom_constructor_is_defensief_en_verwijdert_null_entries() {
        List<Student> given = new ArrayList<>();
        given.add(s("s1", "Alice", "a@x.nl"));
        given.add(null);
        ClassRoom cr = new ClassRoom("INF1", given);

        // Wijziging aan 'given' mag interne lijst niet beïnvloeden
        given.add(s("s2", "Bob", "b@x.nl"));
        assertThat(cr.getStudents()).hasSize(1);
        assertThat(cr.getStudents().get(0).getId()).isEqualTo("s1");
    }

    @Test
    void getStudents_is_defensief() {
        ClassRoom cr = new ClassRoom("INF1", List.of(s("s1", "Alice", null)));
        List<Student> snapshot = cr.getStudents();
        assertThat(snapshot).hasSize(1);

        // Wijzig snapshot; interne lijst mag niet veranderen
        snapshot.add(s("sX", "X", "x@x.nl"));
        assertThat(cr.getStudents()).hasSize(1);
    }

    @Test
    void findById_case_insensitive() {
        ClassRoom cr = new ClassRoom("INF1", List.of(
                s("s1", "Alice", "a@x.nl"),
                s("S2", "Bob", null)
        ));

        assertThat(cr.findById("s1")).isPresent();
        assertThat(cr.findById("S1")).isPresent();
        assertThat(cr.findById("s2")).isPresent();
        assertThat(cr.findById("S2")).isPresent();
        assertThat(cr.findById("unknown")).isEmpty();
    }

    @Test
    void emailOf_combineert_student_niet_gevonden_en_email_ontbreekt() {
        ClassRoom cr = new ClassRoom("INF1", List.of(
                s("s1", "Alice", "alice@school.nl"),
                s("s2", "Bob", null)
        ));

        assertThat(cr.emailOf("s1")).contains("alice@school.nl");
        assertThat(cr.emailOf("s2")).isEmpty();
        assertThat(cr.emailOf("unknown")).isEmpty();

        // Voorbeeld hoe je dit buiten de klasse zou gebruiken:
        String mail = cr.emailOf("s2").orElse("no-reply@school.nl");
        assertThat(mail).isEqualTo("no-reply@school.nl");
    }

    @Test
    void findByName_optional_lijst_case_insensitive_contains() {
        ClassRoom cr = new ClassRoom("INF1", List.of(
                s("s1", "Alice", "a@x.nl"),
                s("s2", "Brian", "b@x.nl"),
                s("s3", "Joanne", "j@x.nl"),
                s("s4", "ANdy", "andy@x.nl")
        ));

        Optional<List<Student>> res1 = cr.findByName("an"); // Alice, Brian, Joanne, ANdy → Brian, Joanne, ANdy bevatten 'an'
        assertThat(res1).isPresent();
        assertThat(res1.get()).extracting(Student::getId).containsExactly("s2", "s3", "s4");

        Optional<List<Student>> res2 = cr.findByName("zz");
        assertThat(res2).isEmpty();
    }

    @Test
    void byEmailDomain_geeft_lege_lijst_bij_geen_matches() {
        ClassRoom cr = new ClassRoom("INF1", List.of(
                s("s1", "Alice", "alice@school.nl"),
                s("s2", "Bob", null),
                s("s3", "Cara", "cara@work.com"),
                s("s4", "Dan", "dan@school.nl")
        ));

        List<Student> school = cr.byEmailDomain("school.nl");
        assertThat(school).extracting(Student::getId).containsExactly("s1", "s4");

        List<Student> none = cr.byEmailDomain("example.org");
        assertThat(none).isEmpty();
    }

    @Test
    void size_werkt_optioneel_en_reflecteert_adds() {
        ClassRoom cr = new ClassRoom("INF1", null);
        assertThat(cr.size()).isZero();
        cr.add(s("s1", "Alice", null));
        cr.add(s("s2", "Bob", null));
        assertThat(cr.size()).isEqualTo(2);
    }
}
