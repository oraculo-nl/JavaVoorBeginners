package java_vervolg.part2;

public class Example19Upcasting {
    static class Animal {
        void makeSound() {
            System.out.println("Some generic animal sound");
        }
    }

    static class Dog extends Animal {
        @Override
        void makeSound() {
            System.out.println("Woof!");
        }
    }

    static class Cat extends Animal {
        @Override
        void makeSound() {
            System.out.println("Meow!");
        }
    }

    /*
    Upcasting is more common than downcasting in Java. It happens
    when you treat a subclass object as its superclass, usually
    to use polymorphism or to store different subclass objects in
    the same collection.
    - Upcasting is automatic — no cast needed
    - It allows us to store different subclass types (Dog, Cat) in
    the same base-type reference (Animal)
    - Method calls are resolved at runtime (dynamic dispatch), so
    the right override is executed
    */
    public static void main(String[] args) {
        // Upcasting: Dog → Animal
        Animal a1 = new Dog();  // implicit upcast
        Animal a2 = new Cat();  // implicit upcast

        // Polymorphism: which sound depends on the *real* object
        a1.makeSound();  // prints "Woof!"
        a2.makeSound();  // prints "Meow!"

        // A heterogeneous collection via upcasting
        Animal[] animals = {new Dog(), new Cat()};
        for (Animal a : animals) {
            a.makeSound();  // dynamic dispatch
        }
    }
}

