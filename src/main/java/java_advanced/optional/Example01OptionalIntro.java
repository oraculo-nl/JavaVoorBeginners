package java_advanced.optional;

import java.util.Optional;
public class Example01OptionalIntro {


    // Zonder Optional: mogelijk null
    static String findNameOldStyle(boolean known) {
        if (known) {
            return "Alice";
        } else {
            return null; // gevaarlijk!
        }
    }

    // Met Optional: expliciet "afwezig"
    static Optional<String> findNameNewStyle(boolean known) {
        if (known) {
            return Optional.of("Alice");          // waarde aanwezig
        } else {
            return Optional.empty();              // expliciet leeg
        }
    }

    public static void main(String[] args) {
        // --- Voorbeeld Optional.of(value) ---
        Optional<String> opt1 = Optional.of("Hallo");
        System.out.println("opt1: " + opt1.get());

        // --- Voorbeeld Optional.ofNullable(value) ---
        String maybeNull = Math.random() > 0.5 ? "Kans" : null;
        Optional<String> opt2 = Optional.ofNullable(maybeNull);
        System.out.println("opt2: " + opt2.orElse("Geen waarde"));

        // --- Voorbeeld Optional.empty() ---
        Optional<String> opt3 = Optional.empty();
        System.out.println("opt3 is leeg? " + opt3.isEmpty());

        // --- Waarom handig ---
        // Oud: null-checks nodig
        String name1 = findNameOldStyle(false);
        if (name1 != null) {
            System.out.println("Naam (oud): " + name1.toUpperCase());
        } else {
            System.out.println("Geen naam gevonden (oud)");
        }

        // Nieuw: veel duidelijker en korter
        String name2 = findNameNewStyle(false)
                .map(String::toUpperCase)   // alleen als aanwezig
                .orElse("Geen naam gevonden (nieuw)");
        System.out.println(name2);
    }
}
