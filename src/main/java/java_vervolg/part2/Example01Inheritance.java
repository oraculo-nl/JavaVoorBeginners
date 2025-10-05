package java_vervolg.part2;

// Superklasse (basis)
class Animal {
    void eat() {
        System.out.println("This animal eats food.");
    }
}

// Subklasse (erft van Animal)
class Dog extends Animal {
    void bark() {
        System.out.println("The dog barks.");
    }
}

public class Example01Inheritance {
    public static void main(String[] args) {
        Dog d = new Dog();

        // methode uit de superklasse
        d.eat();

        // methode uit de subklasse
        d.bark();
    }
}
