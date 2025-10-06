package java_advanced.topic04lambdas;

import java.util.function.Supplier;
import java.util.Random;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Example06Supplier {
    public static void main(String[] args) {
        // Define a Supplier: produces a random integer between 0 and 99
        Supplier<Integer> randomNumber = () -> new Random().nextInt(100);

        // Use the Supplier directly
        System.out.println("Random number: " + randomNumber.get());

        // Use it multiple times (collect 5 random numbers)
        List<Integer> numbers = IntStream.range(0, 5)
                .mapToObj(i -> randomNumber.get())
                .collect(Collectors.toList());

        System.out.println("Five random numbers: " + numbers);

        // Example of a Supplier for a message
        Supplier<String> helloSupplier = () -> "Hello World!";
        System.out.println(helloSupplier.get());
    }
}
