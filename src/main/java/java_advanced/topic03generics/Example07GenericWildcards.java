package java_advanced.topic03generics;

import java.util.*;

public class Example07GenericWildcards {

    static abstract class Animal {
        public abstract void speak();
    }

    static class Dog extends Animal {
        @Override
        public void speak() {
            System.out.println("Woof!");
        }
    }

    static class Cat extends Animal {
        @Override
        public void speak() {
            System.out.println("Meow!");
        }
    }


    // Producer → alleen lezen (extends)
    public static void makeAllSpeak(List<? extends Animal> animals) {
        for (Animal a : animals) {
            a.speak(); // veilig, want alle subtypes hebben speak()
        }
        // animals.add(new Dog()); // niet toegestaan: lijst kan ook List<Cat> zijn
    }

    // Consumer → veilig schrijven (super)
    static void addDogs(List<? super Dog> animals) {
        animals.add(new Dog());        // altijd veilig
        animals.add(new Dog());        // nog één
        Object any = animals.get(0);   // lezen = alleen als Object
        System.out.println("Dog(s) toegevoegd, eerste item type: " + any.getClass().getSimpleName());
    }

    // omdat je wildcards gebruikt is het flexibeler in toewijzing, maar beperkter in gebruik
    // wordt vaak bij API's gebruikt

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>(List.of(new Dog(), new Dog()));
        List<Cat> cats = new ArrayList<>(List.of(new Cat()));
        List<Animal> zoo = new ArrayList<>();
        zoo.add(new Cat());
        zoo.add(new Cat());

        List<Object> things = new ArrayList<>();

        // Producer: ? extends Animal
        System.out.println("makeAllSpeak:");
        makeAllSpeak(dogs);  // werkt met List<Dog>
        makeAllSpeak(cats);  // werkt met List<Cat>

        // Consumer: ? super Dog
        System.out.println("\naddDogs:");
        addDogs(dogs);   // List<Dog> → Dog mag erin
        addDogs(zoo);    // List<Animal> → Dog mag erin
        addDogs(things); // List<Object> → Dog mag erin
    }
}
