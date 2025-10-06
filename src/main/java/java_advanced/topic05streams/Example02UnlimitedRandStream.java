package java_advanced.topic05streams;

import java.util.Random;
import java.util.stream.Stream;

public class Example02UnlimitedRandStream {

    public static void main(String[] args) {
        Random random = new Random();

        // Create an unlimited stream of random numbers (0–99)
        Stream<Integer> randomNumbers = Stream.generate(() -> random.nextInt(100));

        // Application 1: Print the first 10 random numbers
        System.out.println("Ten random numbers:");
        randomNumbers
                .limit(10)                          // limit to 10 values
                .forEach(System.out::println);

        // Application 2: Calculate average of 1,000 random numbers
        double average = Stream.generate(() -> random.nextInt(100))
                .limit(1000)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

        System.out.println("\nAverage of 1000 random numbers: " + average);
    }
}
