package java_vervolg.part2;

/*
protected: zichtbaar voor subklassen en in dezelfde package
binnen in de subklasse kun je de protected methodes wel aanroepen,
maar je kunt ze niet aanroepen op de subklasse zelf

Waarom voorzichtig met pretected zijn?

Doorbreekt encapsulatie sneller
Je stelt interne details bloot aan subklassen die je misschien niet volledig vertrouwt.
Subklassen kunnen afhankelijk worden van implementatiedetails → moeilijker refactoren.
Moeilijker onderhoud
Alles wat protected is, wordt in feite onderdeel van je erfbaar contract.
Je kunt het later niet zomaar wijzigen zonder risico dat bestaande subklassen stukgaan.
Kan leiden tot fragiele hiërarchieën
Als subklassen diep in de interne logica “haken” via protected velden/methoden, wordt de superklasse een soort half-open toolbox.
        Kleine wijzigingen kunnen onverwachte bugs veroorzaken.
        Wanneer wél gebruiken?
        Als je een framework of library bouwt waar je wilt dat anderen kunnen uitbreiden via subclassing.
        Als je heel bewust een extension point aanbiedt.
*/

import java_vervolg.part2_sub_example06.Dog;

public class Example06Protected {


    public static void main(String[] args) {

        Dog d = new Dog("Buddy");

        // Vanuit main() (geen subklasse) kan je 'name' niet direct gebruiken:
//         d.name = "Max";   // compileert niet (protected is niet zichtbaar buiten de klasse of package)

//        d.makeSound(); // compileert ook niet als het direct gebruikt
        d.bark(); //compileert wel, omdat indirect makeSound() aangeroepen wordt.
    }

}





