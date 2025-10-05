package java_advanced.topic01generics;


import java.util.*;

public class Example09FactoryTypeInference {

    static class Utils {
        // Generieke factory-methode
        public static <T> List<T> factory() {
            return new ArrayList<>();
        }
    }

    static class ListExample {
        List<String> namen;

        void run() {
            // Type inferentie: compiler ziet dat het een List<String> moet zijn
            namen = Utils.factory();
            namen.add("Hond");
            namen.add("Kat");
            System.out.println(namen);

            // Expliciet type meegeven: <Integer>
            List<Integer> getallen = Utils.<Integer>factory();
            getallen.add(10);
            getallen.add(20);
            System.out.println(getallen);
            //  Zonder expliciet type kan het soms misgaan:
            var x = Utils.factory();   // x wordt List<Object>
            x.add("Hello");
            x.add(123);
            System.out.println(x);

        }
    }

    public static void main(String[] args) {
        new ListExample().run();
    }
}

