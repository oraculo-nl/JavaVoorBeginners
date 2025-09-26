package java_vervolg.part2;

/*
 * Een enum met een abstract method kun je de Strategy
 * pattern imlementeren
 * */
public class Example32EnumAbstractMethod {
    enum RekeningType {
        // Elke constant moet zelf de methode berekenRente implementeren
        // Invariant: rentepercentage >= 0
        // Invariant: saldo mag nooit negatief worden
        SPAAR {
            @Override
            double berekenRente(double saldo) {
                return saldo * 0.03; // 3% rente
            }
        },
        // Invariant: rentepercentage == 0
        // Invariant: saldo mag negatief zijn (rood staan toegestaan)
        BETAAL {
            @Override
            double berekenRente(double saldo) {
                return saldo * 0.00; // geen rente
            }
        },
        /**
         * BELEGGING:
         * - saldo ≥ 0
         * - rendement kan positief of negatief zijn
         * - geen vast rentepercentage
         */
        BELEGGING {
            @Override
            double berekenRente(double saldo) {
                return saldo * 0.07; // 7% (voorbeeld)
            }
        };

        // Abstracte methode -> verplicht te implementeren door elke constante
        abstract double berekenRente(double saldo);
    }

    public static void main(String[] args) {
        double saldo = 1000.0;

        for (RekeningType type : RekeningType.values()) {
            System.out.println(type + " rente: " + type.berekenRente(saldo));
        }
    }

    // zonder Strategy pattern heb je een switch nodig
    double berekenRente(RekeningType type, double saldo) {
        switch (type) {
            case SPAAR: return saldo * 0.03;
            case BETAAL: return 0.0;
            case BELEGGING: return saldo * 0.07;
            default: throw new IllegalArgumentException();
        }
    }

}

