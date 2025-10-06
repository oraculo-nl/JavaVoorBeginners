package java_advanced.topic04lambdas;

import java.util.List;

public class Example09MethodReferences {

    static class StaticClass {
        static void printUpper(String s) {
            System.out.println(s.toUpperCase());
        }

        void printWithGreeting(String s) {
            System.out.println("Hello, " + s);
        }
    }

    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");

        // 1️⃣ Static method reference
        names.forEach(StaticClass::printUpper);

        // 2️⃣ Instance method reference (on a specific object)
        StaticClass example = new StaticClass();
        names.forEach(example::printWithGreeting);

        // 3️⃣ Instance method reference (on any object of a given type)
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // 4️⃣ Constructor reference
        List<Integer> lengths = names.stream()
                .map(String::length)
                .map(Integer::new) // creates Integer objects
                .toList();

        System.out.println("Lengths: " + lengths);
    }

}

