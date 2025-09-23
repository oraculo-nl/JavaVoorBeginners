package java_vervolg;

import java.util.*;

public class DefensiveCopiesOfMutables {
    public static void main(String[] args) {
        List<String> lijst = new ArrayList<>();
        lijst.add("Java");
        lijst.add("Python");

        Leerling s = new Leerling(lijst);

        // aanroeper probeert de originele lijst te veranderen
        lijst.add("Hacking");
        System.out.println("Externe lijst: " + lijst);

        // interne lijst in Student blijft intact
        System.out.println("Student courses: " + s.getCourses());

        // ook als je de getter gebruikt, kun je de kopie aanpassen
        List<String> viaGetter = s.getCourses();
        viaGetter.add("C++"); // verandert alleen de kopie
        System.out.println("Getter-lijst aangepast: " + viaGetter);
        System.out.println("Student courses na getter-aanpassing: " + s.getCourses());
    }
}




class Leerling {
    private final List<String> courses;

    public Leerling(List<String> courses) {
        // defensive copy bij opslaan
        this.courses = new ArrayList<>(courses);
    }

    public List<String> getCourses() {
        // defensive copy bij teruggeven
        return new ArrayList<>(courses);
    }
}
