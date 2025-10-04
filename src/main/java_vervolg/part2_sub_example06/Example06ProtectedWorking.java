package java_vervolg.part2_sub_example06;

/*
protected: zichtbaar voor subklassen EN in dezelfde package
(binnen in de subklasse kun je de protected methodes wel aanroepen,
maar je kunt ze niet aanroepen op de subklasse zelf)

Waarom voorzichtig met protected zijn?

Doorbreekt encapsulatie sneller
- Je stelt interne details bloot aan subklassen die je misschien niet volledig vertrouwt.
- Subklassen kunnen afhankelijk worden van implementatiedetails → moeilijker refactoren.
*/


public class Example06ProtectedWorking {


    public static void main(String[] args) {

        Dog d = new Dog("Buddy");

        //compileert wel (protected is zichtbaar buiten de klasse want in dezelfde package)
        d.makeSound();
        //compileert wel, omdat indirect makeSound() aangeroepen wordt.
        d.bark();
    }

}





