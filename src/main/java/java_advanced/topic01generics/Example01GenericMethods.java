package java_advanced.topic01generics;

public class Example01GenericMethods {

    // A generic method that prints any type of array
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // A generic method that returns the maximum of three Comparable elements
    public static <T extends Comparable<T>> T maximum(T a, T b, T c) {
        T max = a;  // assume a is the largest
        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }

    public static void main(String[] args) {
        // Example 1: printing arrays
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"Java", "Generics", "Are", "Powerful"};

        System.out.println("Integer Array:");
        printArray(intArray);

        System.out.println("String Array:");
        printArray(strArray);

        // Example 2: finding maximum
        System.out.println("Maximum of 3, 7, 5: " + maximum(3, 7, 5));
        System.out.println("Maximum of apple, orange, banana: "
                + maximum("apple", "orange", "banana"));
    }
}

