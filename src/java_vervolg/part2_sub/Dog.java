package java_vervolg.part2_sub;

// Subklasse in hetzelfde package
public class Dog extends Animal {
    public Dog(String name) {
        this.name = name; // mag, want 'name' is protected
    }

    public void bark() {
        makeSound();
    }
    @Override
    protected void makeSound() { // mag overriden worden
        System.out.println(name + " says: Woof!");
    }
}