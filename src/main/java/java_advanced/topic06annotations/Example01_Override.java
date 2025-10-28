package java_advanced.topic06annotations;

// Example01: Using @Override on a subclass method
class Example01_Override {
    static class Animal {
        void speak() { System.out.println("Animal sound"); }
    }

    static class Dog extends Animal {
        @Override
        void speak() { System.out.println("Woof!"); }
    }

    public static void main(String[] args) {
        new Dog().speak();
    }
}