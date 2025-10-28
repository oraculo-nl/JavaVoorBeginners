package java_advanced.topic06annotations;// Example04: Using @SafeVarargs for generic varargs methods that are type-safe
import java.util.List;

class Example04_SafeVarargs {
    @SafeVarargs
    static <T> void printAll(List<T>... lists) {
        for (List<T> list : lists) {
            for (T item : list) {
                System.out.println(item);
            }
        }
    }

    public static void main(String[] args) {
        printAll(List.of(1,2,3), List.of(4,5));
    }
}