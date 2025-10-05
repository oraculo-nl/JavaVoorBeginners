package java_advanced.oefeningen.topic010203;


import java.util.Optional;

public record ContactDetails(Optional<String> email, Optional<String> phone) {
    public static java_advanced.solutions.ContactDetails ofEmail(String email) { /* TODO */
        return null;
    }

    public static java_advanced.solutions.ContactDetails ofPhone(String phone) { /* TODO */
        return null;
    }

    public static java_advanced.solutions.ContactDetails of(String email, String phone) { /* TODO */
        return null;
    }
}
