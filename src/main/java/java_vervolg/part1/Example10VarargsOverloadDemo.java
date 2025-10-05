package java_vervolg.part1;

public class Example10VarargsOverloadDemo {

    // Overload 1: exacte match
    static void greet(String name) {
        System.out.println("Hello " + name);
    }

    // Overload 2: varargs
    static void greet(String... names) {
        System.out.println("Hello everyone: " + String.join(", ", names));
    }

    public static void main(String[] args) {
        greet("Alice");             // kiest de *exacte match* (String)
        greet("Alice", "Bob");      // kiest de varargs-versie
        greet();                    // kiest ook de varargs-versie (lege array)
    }
}

