package java_advanced.topic04lambdas;

import java.util.List;
import java.util.function.Consumer;

public class Example05Consumer {

    public static void main(String[] args) {
        // Define a Consumer: performs an action (prints the value)
        Consumer<String> printer = s -> System.out.println("Hello, " + s + "!");

        // Apply the Consumer directly
        printer.accept("Alice");
        printer.accept("Bob");

        // Apply the Consumer on each element of a list
        List<String> names = List.of("Ann", "Ben", "Cara");

        System.out.println("\nGreeting everyone:");
        names.forEach(printer);

        // Combine Consumers using andThen() (compound consumer)
        Consumer<String> exclaimer = s -> System.out.println(s + "!!!");
        Consumer<String> combined = printer.andThen(exclaimer);

        System.out.println("\nCombined Consumer:");
        names.forEach(combined);
    }
}
