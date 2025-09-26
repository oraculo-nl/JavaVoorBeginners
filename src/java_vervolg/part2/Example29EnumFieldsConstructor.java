package java_vervolg.part2;

public class Example29EnumFieldsConstructor {
    enum Dag {
        MAANDAG("Begin van de week", 1),
        DINSDAG("Tweede dag", 2),
        WOENSDAG("Midden van de week", 3),
        DONDERDAG("Bijna vrijdag", 4),
        VRIJDAG("Weekend bijna", 5),
        ZATERDAG("Weekend!", 6),
        ZONDAG("Rustdag", 7);

        private final String beschrijving;
        private final int nummer;

        // Constructor (altijd private of package-private)
        Dag(String beschrijving, int nummer) {
            this.beschrijving = beschrijving;
            this.nummer = nummer;
        }

        public String getBeschrijving() {
            return beschrijving;
        }

        public int getNummer() {
            return nummer;
        }
    }

    public static void main(String[] args) {
        Dag vandaag = Dag.WOENSDAG;

        System.out.println(vandaag); // WOENSDAG
        System.out.println(vandaag.getBeschrijving()); // Midden van de week
        System.out.println(vandaag.getNummer());       // 3

        // Alle constanten doorlopen
        for (Dag d : Dag.values()) {
            System.out.println(d + ": " + d.getBeschrijving() + " (" + d.getNummer() + ")");
        }

        //gebruik valueOf als je niet van tevoren weet
        // welke enum-constante je nodig hebt
        System.out.println(Dag.valueOf("WOENSDAG"));

    }
}

