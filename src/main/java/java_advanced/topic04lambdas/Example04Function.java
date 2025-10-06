package java_advanced.topic04lambdas;

import java.util.*;
import java.util.function.Function;

public class Example04Function {

    public static void main(String[] args) {
        List<String> namen = List.of("Hond", "Kat", "Olifant");

        // 1. Zonder lambda (anonieme klasse, alles expliciet)
        Function<String, Integer> f1 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        // 2. Met lambda (types infereren)
        Function<String, Integer> f2 = s -> s.length();

        // 3. Met method reference (nog korter)
        Function<String, Integer> f3 = String::length;

        // Test alle drie
        for (String naam : namen) {
            System.out.println(naam + " → " + f1.apply(naam)
                    + ", " + f2.apply(naam)
                    + ", " + f3.apply(naam));
        }
    }
}

