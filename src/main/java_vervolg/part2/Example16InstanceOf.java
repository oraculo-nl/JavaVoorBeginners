package java_vervolg.part2;

public class Example16InstanceOf {
    static class Animal {
        void sound() {
            System.out.println("Unknown sound");
        }
    }

    static class Dog extends Animal {
        void bark() {
            System.out.println("Woof!");
        }
    }

    static class Cat extends Animal {
        void meow() {
            System.out.println("Meow!");
        }
    }

    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        makeSound(a1);
        makeSound(a2);
    }

    static void makeSound(Animal animal) {
        if (animal instanceof Dog dog) { // pattern matching for instanceof (since Java 16)
            dog.bark();
        } else if (animal instanceof Cat cat) {
            cat.meow();
        } else {
            animal.sound();
        }
    }
}

