package arrays_en_methods;

import java.util.Locale;
import java.util.Scanner;

public class BerekenEindbedrag {
    public static void main(String[] args) {
        var s = new Scanner(System.in);
        System.out.println("Voer een bedrag in:");
        var bedrag = s.nextInt();
        System.out.println("Voer een maandrente in:");
        var rente = s.nextFloat();
        var eindBedrag = berekenEindbedrag(bedrag, rente);
        System.out.println("Uw eindbedrag bedraagt na 10 jaar:");
        System.out.println(eindBedrag);
        System.out.printf(Locale.GERMAN, "Geformateerd:%n%,.2f", eindBedrag);
    }

    static float berekenEindbedrag(float beginBedrag, float maandRente) {
        for (var i = 1; i <= 10; i++)
            for (var j = 1; j <= 12; j++) {
                beginBedrag *= 1 + (maandRente / 100);
            }
        return beginBedrag;
    }
}
