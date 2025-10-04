package java_vervolg.oefeningen.oefening1;

// package nl.school.vehicles;

public abstract class Vehicle {
    private final String brand;   // alleen via getters (encapsulation)
    private final String vin;     // uniek serienummer, niet zichtbaar in subklassen
    protected int year;           // wel zichtbaar in subklassen
    int serviceIntervalKm = 15000; // (default) package-private voorbeeld

    // Overloaded ctor 1: volledige invoer
    public Vehicle(String brand, int year, String vin) {
        if (brand == null || brand.isBlank()) {
            throw new IllegalArgumentException("brand must not be blank");
        }
        if (year < 1950 || year > 2100) {
            throw new IllegalArgumentException("year is unrealistic: " + year);
        }
        if (vin == null || vin.isBlank()) {
            throw new IllegalArgumentException("vin must not be blank");
        }
        this.brand = brand;
        this.year = year;
        this.vin = vin;
    }

    // Overloaded ctor 2: VIN intern genereren
    public Vehicle(String brand, int year) {
        this(brand, year, generateVin(brand, year));
    }

    // Private helper: niet buiten Vehicle zichtbaar
    private static String generateVin(String brand, int year) {
        String p = brand.substring(0, Math.min(3, brand.length())).toUpperCase();
        return p + "-" + year + "-" + System.nanoTime();
    }

    public String getBrand() { return brand; }
    public String getVin()   { return vin; }
    public int getYear()     { return year; }

    // Concreet gedrag dat subklassen erven
    public String label() {
        return getBrand() + " (" + getYear() + ")";
    }

    // Abstract gedrag: dwing implementatie in subklassen
    public abstract double rangeKm();

    @Override
    public String toString() {
        return "Vehicle{brand=" + brand + ", year=" + year + ", vin=" + vin + "}";
    }

    // Optioneel maar nuttig: identiteit op VIN
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle v)) return false;
        return vin.equals(v.vin);
    }

    @Override
    public int hashCode() {
        return vin.hashCode();
    }
}
