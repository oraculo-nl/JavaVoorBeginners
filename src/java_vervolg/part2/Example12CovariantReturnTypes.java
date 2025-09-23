package java_vervolg.part2;


/*
Covariant return types = een override-methode in een subklasse
 mag een specifieker type teruggeven dan de methode in de superklasse
 */

public class Example12CovariantReturnTypes {
    static class Animal {
        String name = "Generic animal";
    }

    static class Dog extends Animal {
        Dog() {
            this.name = "Dog";
        }
    }

    static class AnimalShelter {
        // Basismethode
        Animal getAnimal() {
            return new Animal();
        }
    }

    static class DogShelter extends AnimalShelter {
        // Override met covariant return type:
        // Subklasse mag een SPECIFIEKER type teruggeven
        @Override
        Dog getAnimal() {
            return new Dog();
        }
    }


    public static void main(String[] args) {
        AnimalShelter aShelter = new AnimalShelter();
        DogShelter dShelter = new DogShelter();

        Animal a = aShelter.getAnimal(); // geeft een Animal
        Dog d = dShelter.getAnimal();    // geeft direct een Dog, geen cast nodig

        System.out.println("From AnimalShelter: " + a.name);
        System.out.println("From DogShelter: " + d.name);
    }
}

