package java_vervolg.part2;

/*
Inheritance (extends):
Dog is-a kind of Animal. It automatically gets all Animal behavior and can add more.
Good when there’s a clear is-a relationship.

Composition (has-a):
Car has-an Engine. The Car doesn’t become an Engine, it just uses one internally.
Good for flexibility (you can swap the Engine type, decorate, delegate, etc.).
*/


public class Example04CompositeVsInheritance {

    public static void main(String[] args) {
        var outer = new Example04CompositeVsInheritance();
        // Inheritance usage
        Dog d = outer.new Dog();
        d.eat();   // method from Animal
        d.bark();  // method from Dog

        // Composition usage
        Car c = outer.new Car();
        c.drive(); // Car uses its Engine internally
    }

    // INHERITANCE EXAMPLE
// Dog IS-A Animal (uses extends keyword)
    class Animal {
        void eat() {
            System.out.println("This animal eats food.");
        }
    }

    class Dog extends Animal {   // inheritance
        void bark() {
            System.out.println("The dog barks.");
        }
    }


    // COMPOSITION EXAMPLE
// Car HAS-A Engine (engine is a field, not a parent class)
    class Engine {
        void start() {
            System.out.println("Engine starting...");
        }
    }

    class Car {   // composition
        private final Engine engine = new Engine(); // Car has an Engine

        void drive() {
            engine.start(); // delegate to the Engine
            System.out.println("Car is driving.");
        }
    }

}

