package java_vervolg.oefeningen.oefening1;

// package nl.school.vehicles;

public class Car extends Vehicle {
    private final int engineCc; // bijv. 1600 = 1.6 liter

    // Overloaded ctor met expliciete VIN
    public Car(String brand, int year, String vin, int engineCc) {
        super(brand, year, vin);
        if (engineCc <= 0) throw new IllegalArgumentException("engineCc must be > 0");
        this.engineCc = engineCc;
    }

    // Overloaded ctor zonder VIN (intern gegenereerd)
    public Car(String brand, int year, int engineCc) {
        super(brand, year);
        if (engineCc <= 0) throw new IllegalArgumentException("engineCc must be > 0");
        this.engineCc = engineCc;
    }

    public int getEngineCc() { return engineCc; }

    @Override
    public double rangeKm() {
        // Eenvoudige schatting:
        // basisverbruik groeit met motorinhoud (cc).
        // l/100km = max(4.5, 3.0 + (engineCc / 1000.0) * 3.5)
        double lPer100 = Math.max(4.5, 3.0 + (engineCc / 1000.0) * 3.5);
        double tankLiters = 50.0;
        return (tankLiters / lPer100) * 100.0;
    }

    @Override
    public String toString() {
        return "Car{brand=" + getBrand()
                + ", year=" + getYear()
                + ", engineCc=" + engineCc
                + ", vin=" + getVin() + "}";
    }
}

