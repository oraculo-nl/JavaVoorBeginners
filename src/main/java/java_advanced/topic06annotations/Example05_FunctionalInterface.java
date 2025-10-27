package java_advanced.topic06annotations;

// Example05: Defining a functional interface with @FunctionalInterface
@FunctionalInterface
interface StringMapper {
    String map(String in);
    // If you try to add another abstract method, the compiler will error.
}

class Example05_FunctionalInterface {
    public static void main(String[] args) {
        StringMapper upper = s -> s.toUpperCase();
        System.out.println(upper.map("hello"));
    }
}