package java_advanced.topic04lambdas;

import java.util.function.BiFunction;

public class Example07BiFunction {

    public static void main(String[] args) {
        // Define a BiFunction: takes two Integers and returns their sum as Integer
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

        int result = add.apply(5, 3);
        System.out.println("Sum: " + result); // Output: 8

        // Another BiFunction: combine two Strings
        BiFunction<String, String, String> fullName =
                (first, last) -> first + " " + last;

        System.out.println("Full name: " + fullName.apply("Ada", "Lovelace"));

        // You can also chain BiFunctions with andThen()
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        var multiplyThenToString = multiply.andThen(r -> "Result: " + r);

        System.out.println(multiplyThenToString.apply(4, 5)); // Output: Result: 20
    }
}
