package java_advanced.topic03generics;

public class Example06GenericComparable {

    // Generieke methode met Comparable-bound
    // let op: ook al is het een interface, je gebruikt
    // keyword 'extends'
    public static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    // Een custom class Person die Comparable implementeert
    static class Person implements Comparable<Person> {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        //de vergelijking bepaal je zelf
        @Override
        public int compareTo(Person other) {
            // Vergelijk op leeftijd
            return Integer.compare(this.age, other.age);
        }

        @Override
        public String toString() {
            return name + " (" + age + ")";
        }
    }

    public static void main(String[] args) {
        // Voorbeelden met ingebouwde types
        System.out.println("Max van 10 en 20 = " + max(10, 20));
        System.out.println("Max van 'apple' en 'orange' = " + max("apple", "orange"));
        System.out.println("Max van 3.14 en 2.71 = " + max(3.14, 2.71));

        // Voorbeeld met custom type Person
        Person alice = new Person("Alice", 30);
        Person bob = new Person("Bob", 25);

        System.out.println("Max van Alice en Bob (oudste persoon) = " + max(alice, bob));
    }
}
