package java_vervolg.part2;

public class Example13SuperMethod {
    static class Animal {
        void makeSound() {
            System.out.println("Some generic animal sound");
        }
    }

    static class Dog extends Animal {
        @Override
        void makeSound() {
            super.makeSound(); // roept de versie van Animal aan
            System.out.println("Woof woof!");
        }
    }

    public static void main(String[] args) {
        Dog d = new Dog();
        d.makeSound();
    }
}

