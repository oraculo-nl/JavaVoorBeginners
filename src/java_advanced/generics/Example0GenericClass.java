package java_advanced.generics;

public class Example0GenericClass {
    // A generic Box class that can hold any type
    public static class Box<T> {
        private T value;

        public Box(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public static void main(String[] args) {
            // Box of Integer
            Box<Integer> intBox = new Box<>(123);
            System.out.println("Integer value: " + intBox.getValue());

            // Box of String
            Box<String> strBox = new Box<>("Hello Generics");
            System.out.println("String value: " + strBox.getValue());

            // Box of Double
            Box<Double> dblBox = new Box<>(3.14);
            System.out.println("Double value: " + dblBox.getValue());
        }
    }
}