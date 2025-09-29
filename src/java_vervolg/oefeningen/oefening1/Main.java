package java_vervolg.oefeningen.oefening1;

// package nl.school.vehicles;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> fleet = List.of(
                new Car("Toyota", 2018, 1600),
                new ElectricCar("Tesla", 2023, 75.0),
                new Car("VW", 2012, "WV-2012-ABC", 1400),
                new ElectricCar("Renault", 2020, "RE-2020-XYZ", 52.0)
        );

        for (Vehicle v : fleet) {
            System.out.println(v.label()
                    + " -> range ~ " + Math.round(v.rangeKm()) + " km");
            System.out.println("  " + v); // type-specifieke toString()
        }

        // Voorbeeld access-tests (bewust comment laten staan):
        // v.year = 1999;                       // compile error: v is niet in subklasse-context
        // System.out.println(v.vin);           // compile error: private in Vehicle
        // System.out.println(v.serviceIntervalKm); // compile error buiten package
    }
}
