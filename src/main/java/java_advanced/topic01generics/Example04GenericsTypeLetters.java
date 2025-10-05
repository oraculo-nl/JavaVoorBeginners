package java_advanced.topic01generics;

import java.util.*;

// E = Element
class MyList<E> {
    private List<E> items = new ArrayList<>();

    public void add(E element) {
        items.add(element);
    }

    public E get(int index) {
        return items.get(index);
    }
}

// T, U, V = willekeurige typeparameters
class Triple<T, U, V> {
    private T first;
    private U second;
    private V third;

    public Triple(T first, U second, V third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public V getThird() {
        return third;
    }
}

// R = Result
class Calculator {
    public static <R> R identity(R value) {
        return value; // geeft dezelfde waarde terug
    }
}

public class Example04GenericsTypeLetters {

    public static void main(String[] args) {
        // E
        MyList<String> names = new MyList<>();
        names.add("Alice");
        System.out.println("Naam: " + names.get(0));

        // T, U, V
        Triple<String, Integer, Boolean> triple = new Triple<>("Bob", 42, true);
        System.out.println("Triple: " + triple.getFirst() + ", "
                + triple.getSecond() + ", "
                + triple.getThird());

        // R
        String result = Calculator.identity("Hello");
        Integer number = Calculator.identity(99);
        System.out.println("Resultaten: " + result + ", " + number);
    }
}
