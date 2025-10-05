package java_advanced.solutions;


import java.util.Optional;

public class PersonUtils {

    /**
     * Kies e-mail als primair, anders telefoon, anders leeg.
     */
    public static Optional<String> primaryContact(Person p) {
        return p.contact()
                .flatMap(cd -> cd.email().or(() -> cd.phone()));
    }

    /**
     * "Alice (email: a@b.c)" | "Alice (phone: 06-...)" | "Alice (no contact)".
     */
    public static String contactLabel(Person p) {
        return primaryContact(p)
                .map(v -> {
                    boolean isEmail = p.contact().flatMap(c -> c.email()).isPresent();
                    return p.name() + (isEmail ? " (email: " + v + ")" : " (phone: " + v + ")");
                })
                .orElse(p.name() + " (no contact)");
    }
}

