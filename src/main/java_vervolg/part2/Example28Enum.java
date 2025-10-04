package java_vervolg.part2;

public class Example28Enum {
    // Enum declaratie
    enum Dag {
        MAANDAG, DINSDAG, WOENSDAG, DONDERDAG, VRIJDAG, ZATERDAG, ZONDAG
    }

    public static void main(String[] args) {
        // Een enum gebruiken
        Dag vandaag = Dag.MAANDAG;

        // Switch op een enum
        switch (vandaag) {
            case MAANDAG:
                System.out.println("Het is maandag, begin van de week!");
                break;
            case VRIJDAG:
                System.out.println("Bijna weekend!");
                break;
            case ZATERDAG:
            case ZONDAG:
                System.out.println("Weekend!");
                break;
            default:
                System.out.println("Een gewone dag.");
        }

        // Alle waarden van de enum doorlopen
        for (Dag d : Dag.values()) {
            System.out.println(d);
        }
    }
}
