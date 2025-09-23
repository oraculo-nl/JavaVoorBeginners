package java_vervolg.part2_sub;

// Superklasse
public class Animal {
    protected String name; // protected veld, zichtbaar voor subklassen

    protected void makeSound() { // protected methode
        System.out.println("Some generic animal sound");
    }
}
