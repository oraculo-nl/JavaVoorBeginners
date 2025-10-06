package java_advanced.topic03generics;

import java.util.HashMap;
import java.util.Map;

public class Example02GenericMap {

    public static void main(String[] args) {
        // K = String, V = Integer
        Map<String, Integer> ages = new HashMap<>();

        // Waarden toevoegen
        ages.put("Alice", 30);
        ages.put("Bob", 25);
        ages.put("Charlie", 35);

        // Ophalen via de key
        int ageOfBob = ages.get("Bob");
        System.out.println("Leeftijd van Bob: " + ageOfBob);

        // Itereren over entries
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            String name = entry.getKey();
            Integer age = entry.getValue();
            System.out.println(name + " is " + age + " jaar oud");
        }
    }
}
