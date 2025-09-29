package java_vervolg.part1;

import java.util.*;

public class Example13UnmodifiableWrappers {

    // voor lijsten kun je gebruik maken van
    // 1. Collections.unmodifiableList om een read-only view terug te krijgen (geeft wel nieuwe veranderingen weer)
    // 2. List.of() geeft een kopie als lijst terug, die


    public static void main(String[] args) {
        var uw = new Example13UnmodifiableWrappers();
        Student s = uw.new Student();
        List<String> lijst = s.getCourses();

        System.out.println(lijst); // [Java, Python]

        // probeer aan te passen → geeft runtime exception

        try {
            lijst.add("Hacking");
        } catch (Exception e) {
            System.out.println("Cannot add element to unmodifiable list");
        }



        lijst = s.getCoursesAsList();
        System.out.println(lijst); // [Java, Python]
        try {
            lijst.add("Hacking");
        } catch (Exception e) {
            System.out.println("Cannot add element to List.of list");
        }


        //met lijst ref werkt het wel maar is gevaarlijk en leidt tot bugs
        System.out.println(lijst); // [Java, Python]

        lijst = s.getCoursesRef();
        lijst.add("Hacking");

        System.out.println("works with ref"); // [Java, Python]
        System.out.println(lijst);

    }

    /**
     * Represents a Student with an unmodifiable list of courses.
     * <p>
     * The list returned by {@link #getCourses()} is unmodifiable:
     * attempts to change it will result in {@link UnsupportedOperationException}.
     * </p>
     * This class is immutable.
     */
    class Student {
        private final List<String> courses = new ArrayList<>();

        public Student() {
            courses.add("Java");
            courses.add("Python");
        }

        // Alleen een unmodifiable view teruggeven
        public List<String> getCourses() {
            return Collections.unmodifiableList(courses);
        }

        public List<String> getCoursesAsList() {
            return List.of(courses.toArray(new String[0]));
        }

        public List<String> getCoursesRef() {
            return courses;
        }

    }

}



