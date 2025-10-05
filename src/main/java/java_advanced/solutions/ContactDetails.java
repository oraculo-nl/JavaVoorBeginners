package java_advanced.solutions;


import java.util.Objects;
import java.util.Optional;

public record ContactDetails(Optional<String> email, Optional<String> phone) {

    public ContactDetails {
        email = Objects.requireNonNullElse(email, Optional.empty());
        phone = Objects.requireNonNullElse(phone, Optional.empty());
    }

    public static ContactDetails ofEmail(String email) {
        return new ContactDetails(Optional.ofNullable(email), Optional.empty());
    }

    public static ContactDetails ofPhone(String phone) {
        return new ContactDetails(Optional.empty(), Optional.ofNullable(phone));
    }

    public static ContactDetails of(String email, String phone) {
        return new ContactDetails(Optional.ofNullable(email), Optional.ofNullable(phone));
    }
}
