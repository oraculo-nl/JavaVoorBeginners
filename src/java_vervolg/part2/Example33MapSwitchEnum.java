package java_vervolg.part2;

import java.util.Map;

public class Example33MapSwitchEnum {

    enum Dier {
        HOND {
            @Override
            public void maakGeluid() {
                System.out.println("Woef!");
            }
        },
        KAT {
            @Override
            public void maakGeluid() {
                System.out.println("Miauw!");
            }
        },
        KOE {
            @Override
            public void maakGeluid() {
                System.out.println("Boe!");
            }
        };

        public abstract void maakGeluid();
    }


    public static void main(String[] args) {

        /*
        Map en een switch gebruiken om gedrag aan een sleutel te koppelen
         */
        String dierS = "HOND";
        int geluid = Map.of(
                "HOND", 1,
                "KAT", 2,
                "KOE", 3
        ).getOrDefault(dierS, 0);

        switch (geluid) {
            case 1 -> System.out.println("Woef!");
            case 2 -> System.out.println("Miauw!");
            case 3 -> System.out.println("Boe!");
            default -> System.out.println("Onbekend geluid");
        }

        /*
        Mbv enum gedrag koppelen
         */
        Dier dier = Dier.HOND;
        dier.maakGeluid(); // Roept direct het gedrag aan, geen switch of map nodig

    }
}

