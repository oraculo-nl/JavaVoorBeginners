package java_advanced.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClassRoom {
    private String name;
    private List<Student> students = new ArrayList<>();

    public ClassRoom(String name) {
        this.name = name;
    }

    public ClassRoom(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public void add(Student s) {
        students.add(s);
    }

    public void addAll(List<Student> s) {
        students.addAll(s);
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public Optional<Student> findById(String id) {
        // find student from ArrayList
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }

    public Optional<String> emailOf(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return Optional.ofNullable(s.getEmail());
            }
        }
        return Optional.empty();
    }

    public Optional<List<Student>> findByName(String name) {
        List<Student> foundStudents = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().equals(name)) {
                foundStudents.add(s);
            }
        }
        return Optional.of(foundStudents);
    }

    public List<Student> byEmailDomain(String domain) {
        List<Student> foundStudents = new ArrayList<>();
        for (Student s : students) {
            if (s.getEmail().endsWith("@" + domain)) {
                foundStudents.add(s);
            }
        }
        return foundStudents;
    }

    public int size() {
        return students.size();
    }

}
