package java_advanced.topic04lambdas;

import java.util.*;

public class Example08SortingComparator {

    public static void main(String[] args) {
        List<String> dieren = new ArrayList<>(List.of("Hond", "Kat", "Olifant"));

        // Zonder lambda: expliciet alle generics uitschrijven
        dieren.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return Integer.compare(a.length(), b.length());
            }
        });
        System.out.println("Gesorteerd zonder lambda: " + dieren);

        // Met lambda: types worden automatisch geïnferreerd
        dieren.sort((a, b) -> Integer.compare(a.length(), b.length()));
        System.out.println("Gesorteerd met lambda: " + dieren);

        // Met method reference: nog korter
        dieren.sort(Comparator.comparingInt(String::length));
        System.out.println("Gesorteerd met method reference: " + dieren);
    }
}
