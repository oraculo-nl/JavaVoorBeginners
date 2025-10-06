package java_advanced.topic04lambdas;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Example03Predicate {

    public static void main(String[] args) {
        // Sample data
        List<String> names = List.of("Alice", "Bob", "Ann", "Charlie", "Alex");

        // Define a Predicate: tests if name starts with 'A'
        Predicate<String> startsWithA = name -> name.startsWith("A");

        // Apply the predicate (filter list)
        List<String> result = names.stream()
                .filter(startsWithA)
                .collect(Collectors.toList());

        System.out.println("Names starting with A: " + result);

        // Combine predicates (AND, OR, NEGATE)
        Predicate<String> longName = name -> name.length() > 3;

        List<String> combined = names.stream()
                .filter(startsWithA.and(longName))
                .collect(Collectors.toList());

        System.out.println("Names starting with A and longer than 3 letters: " + combined);
    }
}
