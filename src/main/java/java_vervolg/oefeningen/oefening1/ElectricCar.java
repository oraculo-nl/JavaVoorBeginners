package java_vervolg.oefeningen.oefening1;

// package nl.school.vehicles;

public class ElectricCar extends Vehicle {
    private final double batteryKWh; // bijv. 60.0

    // Overloaded ctor met expliciete VIN
    public ElectricCar(String brand, int year, String vin, double batteryKWh) {
        super(brand, year, vin);
        if (batteryKWh <= 0.0) throw new IllegalArgumentException("batteryKWh must be > 0");
        this.batteryKWh = batteryKWh;
    }

    // Overloaded ctor zonder VIN (intern gegenereerd)
    public ElectricCar(String brand, int year, double batteryKWh) {
        super(brand, year);
        if (batteryKWh <= 0.0) throw new IllegalArgumentException("batteryKWh must be > 0");
        this.batteryKWh = batteryKWh;
    }

    public double getBatteryKWh() { return batteryKWh; }

    @Override
    public double rangeKm() {
        // Eenvoudige schatting: verbruik 15 kWh / 100km
        double kWhPer100 = 15.0;
        return (batteryKWh / kWhPer100) * 100.0;
    }

    @Override
    public String toString() {
        return "ElectricCar{brand=" + getBrand()
                + ", year=" + getYear()
                + ", batteryKWh=" + batteryKWh
                + ", vin=" + getVin() + "}";
    }
}
