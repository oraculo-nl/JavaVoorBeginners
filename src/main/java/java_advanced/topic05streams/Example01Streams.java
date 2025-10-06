package java_advanced.topic05streams;

import java.util.*;
import java.util.stream.*;

public class Example01Streams {

    public static void main(String[] args) {

        // --- 1️⃣ Stream from a List ---
        List<String> names = List.of("Alice", "Bob", "Alex", "Charlie");

        // Filter names starting with 'A' and print them
        System.out.println("Names from List starting with 'A':");
        names.stream()
                .filter(n -> n.startsWith("A"))
                .forEach(System.out::println);

        // Count how many names have more than 3 letters
        long longNames = names.stream()
                .filter(n -> n.length() > 3)
                .count();
        System.out.println("Number of long names: " + longNames);


        // --- 2️⃣ Stream from an Array ---
        int[] numbers = {3, 7, 2, 8, 5};

        // Convert to IntStream and find average
        double avg = Arrays.stream(numbers)
                .average()
                .orElse(0);

        System.out.println("\nAverage of numbers: " + avg);

        // Create a new array with doubled values
        int[] doubled = Arrays.stream(numbers)
                .map(n -> n * 2)
                .toArray();

        System.out.println("Doubled numbers: " + Arrays.toString(doubled));
    }
}
