package java_advanced.topic06annotations;// Example03: Using @SuppressWarnings to silence legit known warnings
import java.util.ArrayList;
import java.util.List;

class Example03_SuppressWarnings {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    static void rawListUsage() {
        List list = new ArrayList();
        list.add("hello");
        list.add(123); // mixed types — not type-safe, but we're demonstrating the warning
        System.out.println(list);
    }

    public static void main(String[] args) {
        rawListUsage();
    }
}