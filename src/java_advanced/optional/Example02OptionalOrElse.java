package java_advanced.optional;

import java.util.Optional;

public class Example02OptionalOrElse {


    public static void main(String[] args) {

        // of(value) → mag niet null zijn
        Optional<String> opt1 = Optional.of("Hallo");
        System.out.println(opt1.get()); // "Hallo"

        // ofNullable(value) → accepteert null
        String maybeNull = Math.random() > 0.5 ? "Kans" : null;
        Optional<String> opt2 = Optional.ofNullable(maybeNull);

        // empty()
        Optional<String> opt3 = Optional.empty();

        // --- Gebruik ---
        // 1) orElse → vaste fallback
        String res1 = opt2.orElse("Geen waarde (orElse)");

        // 2) orElseGet → fallback via lambda (lui)
        String res2 = opt2.orElseGet(() -> "Berekende fallback");

        // 3) orElseThrow → gooi exception als leeg
        try {
            String res3 = opt3.orElseThrow(() ->
                    new IllegalStateException("Verplichte waarde ontbreekt!"));
            System.out.println(res3);
        } catch (Exception e) {
            System.out.println("Foutmelding: " + e.getMessage());
        }

        System.out.println(res1);
        System.out.println(res2);
    }
}

