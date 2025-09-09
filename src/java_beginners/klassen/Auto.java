package java_beginners.klassen;

public class Auto {
    int snelheid = 0;
    String merk = "Toyota";
    int kilometerstand = 23000;

    public void start() {
        System.out.println("de auto start");
    }

    public void stop() {
        System.out.println("de auto stopt");
    }

    public void geefGas() {
        System.out.println("de auto rijdt");
    }

    public int getKilometerStand() {
        return kilometerstand;
    }

    public static void main(String[] args) {
        var toyota = new Auto();
        toyota.start();
        toyota.geefGas();
        toyota.stop();
        System.out.println("De kilometerstand is:" + toyota.getKilometerStand());
    }
}
