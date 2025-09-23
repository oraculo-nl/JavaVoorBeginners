package java_vervolg.part2;

/*
* assert is normally only used in unit tests
*
* By default, Java ignores assert statements at runtime.
* To make them work, you need to enable assertions with a JVM flag.
* in IntelliJ in the run configuration you need to add VM options and
* put -ea in there
* */

public class Example21Asserts {
    static abstract class Animal {
        abstract String sound();
    }

    static class Dog extends Animal {
        @Override
        String sound() {
            return "Woof";
        }
    }

    static class Cat extends Animal {
        @Override
        String sound() {
            return "Meow";
        }
    }

    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        // Assertions validate polymorphic behavior
        // these assertions would generate an exception
        assert a1.sound().equals("Meow") : "Dog should say Woof";
        assert a2.sound().equals("Woof") : "Cat should say Meow";

        // these assertions would succeed, but no output
        assert a1.sound().equals("Woof") : "Dog should say Woof";
        assert a2.sound().equals("Meow") : "Cat should say Meow";
    }
}



