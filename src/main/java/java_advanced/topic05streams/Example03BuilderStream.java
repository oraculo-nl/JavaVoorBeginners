package java_advanced.topic05streams;

import java.util.stream.Stream;

public class Example03BuilderStream {
    static record Student(String name, int grade) {
    }

    public static void main(String[] args) {
        Stream<Student> students = Stream.<Student>builder()
                .add(new Student("Alice", 8))
                .add(new Student("Bob", 6))
                .add(new Student("Charlie", 9))
                .build();

        double avg = students
                .mapToInt(Student::grade)
                .average()
                .orElse(0);

        System.out.println("Average grade: " + avg);
    }
}

