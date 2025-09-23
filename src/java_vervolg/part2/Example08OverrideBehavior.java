package java_vervolg.part2;



public class Example08OverrideBehavior {
    // Superklasse
    static class Animal {
        void makeSound() {
            System.out.println("Some generic animal sound");
        }
    }

/*
    gebruik @override
    - Je vangt typefouten en signatuur-fouten vroeg.
    - Je ziet meteen of je echt een override doet.
    - Het voorkomt dat je onbedoeld nieuwe methoden introduceert i.p.v. bestaande overschrijft.
*/

    // Subklasse 1
    static class Dog extends Animal {
        @Override
        void makeSound() { // override
            System.out.println("Woof!");
        }
    }

    // Subklasse 2
    static class Cat extends Animal {
        @Override
        void makeSound() { // override
            System.out.println("Meow!");
        }
    }

    // Testklasse
    public static void main(String[] args) {
        Animal a1 = new Animal();
        Animal a2 = new Dog();   // polymorfisme: Animal-referentie, Dog-object
        Animal a3 = new Cat();   // idem maar met Cat

        a1.makeSound(); // roept Animal's versie aan
        a2.makeSound(); // roept Dog's override aan
        a3.makeSound(); // roept Cat's override aan
        /*
        Dit wordt ook wel polymorfisme genoemd
        */

    }
}
