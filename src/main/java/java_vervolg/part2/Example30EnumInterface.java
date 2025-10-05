package java_vervolg.part2;

public class Example30EnumInterface {
    // Interface
    interface Geluid {
        String maakGeluid();
    }

    // Enum die de interface implementeert
    enum Dier implements Geluid {
        HOND {
            @Override
            public String maakGeluid() {
                return "Woef";
            }
        },
        KAT {
            @Override
            public String maakGeluid() {
                return "Miauw";
            }
        },
        KOE,
        KALF;
        @Override
        public String maakGeluid() {
            return "Boe";
        }
    }

    public static void main(String[] args) {
        // Enum gebruiken via de interface
        for (Dier d : Dier.values()) {
            System.out.println(d + " zegt: " + d.maakGeluid());
        }
    }
}

