package java_vervolg.part2;

import java.util.Objects;

public class Example10EqualsHashCode {


    static class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Override equals: bepaalt wanneer twee Students gelijk zijn
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;                 // zelfde object
            if (!(o instanceof Student other)) return false; // type check + cast
            return age == other.age && Objects.equals(name, other.name);
        }

        // Override hashCode: verplicht bij equals
        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', age=" + age + "}";
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Alice", 21);
        Student s2 = new Student("Alice", 21);
        Student s3 = new Student("Bob", 23);

        // Zonder override: false (== vergelijkt referenties)
        System.out.println("s1.equals(s2)? " + s1.equals(s2)); // true
        System.out.println("s1.equals(s3)? " + s1.equals(s3)); // false

        // Hashcodes gelijk als inhoud gelijk is
        System.out.println("s1.hashCode(): " + s1.hashCode());
        System.out.println("s2.hashCode(): " + s2.hashCode());
        System.out.println("s3.hashCode(): " + s3.hashCode());
    }
}
