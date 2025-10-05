package java_vervolg.part2;

public class Example18Downcasting {
    static class Animal {
        void eat() {
            System.out.println("Animal is eating");
        }
    }

    static class Dog extends Animal {
        void bark() {
            System.out.println("Dog is barking");
        }
    }

    /*
    Here’s a very simple Java example where you really need
     a downcast because you want to access functionality
      that only exists in the subclass
    */
    public static void main(String[] args) {
        Animal a = new Dog();   // Upcasting: Dog → Animal
        a.eat();                // Works: eat() is in Animal

        // a.bark();  // Compile error: bark() is not in Animal

        // Downcasting: Animal → Dog
        if (a instanceof Dog) {
            Dog d = (Dog) a;
            d.bark();           // Now works
        }
    }
}

