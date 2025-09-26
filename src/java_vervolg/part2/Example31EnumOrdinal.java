package java_vervolg.part2;

public class Example31EnumOrdinal {
    enum Dag {
        MAANDAG, DINSDAG, WOENSDAG, DONDERDAG, VRIJDAG, ZATERDAG, ZONDAG
    }

    public static void main(String[] args) {
        Dag vandaag = Dag.WOENSDAG;

        // Ordinal van een specifieke waarde
        System.out.println("Vandaag is: " + vandaag);
        System.out.println("Ordinal is: " + vandaag.ordinal());

        // Alle dagen en hun ordinal tonen
        for (Dag d : Dag.values()) {
            System.out.println(d + " -> " + d.ordinal());
        }
    }
}
