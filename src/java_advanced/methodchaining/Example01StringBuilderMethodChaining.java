package java_advanced.methodchaining;

public class Example01StringBuilderMethodChaining {
    public static void main(String[] args) {
        // Zonder method chaining (klassieke string-concatenatie)
        String tekst1 = "Hallo";
        tekst1 += " wereld";
        tekst1 += "!";
        System.out.println(tekst1);

        // Met method chaining via StringBuilder
        StringBuilder builder = new StringBuilder();
        String tekst2 = builder
                .append("Hallo")
                .append(" wereld")
                .append("!")
                .toString(); // eindigt de keten

        System.out.println(tekst2);
    }
}
