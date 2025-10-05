package java_advanced.oefeningen.topic010203;

import java.util.Optional;

public class PersonUtils {
    // Kies e-mail als primair, anders telefoon, anders leeg
    public static Optional<String> primaryContact(Person p) {
        // TODO: flatMap/map keten, geen get()
        return Optional.empty();
    }

    // Bouw label: "Alice (email: a@b.c)" of "Alice (phone: 06-...)" of "Alice (no contact)"
    public static String contactLabel(Person p) {
        // TODO: map / orElse
        return "";
    }
}
