package java_advanced.optional;

import java.util.Optional;

public class Example03OptionalIfPresent {

    public static void main(String[] args) {
        Optional<String> opt1 = Optional.of("Hallo");
        Optional<String> opt2 = Optional.empty();

        // ifPresent voert de lambda alleen uit als er een waarde is
        opt1.ifPresent( value -> System.out.println("Waarde: " + value));
        opt2.ifPresent(value -> System.out.println("Komt hier nooit"));

        System.out.println("Klaar!");
    }
}

