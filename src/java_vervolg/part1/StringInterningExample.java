package java_vervolg.part1;

public class StringInterningExample {
    public static void main(String[] args) {

        //twee strings met dezelfde inhoud EN reference
        System.out.println("===========================");

        String naam1 = "Jan";
        String naam2 = "Jan";

        System.out.println("naam1: " + naam1);
        System.out.println("naam2: " + naam2);

        System.out.println(naam1 == naam2);
        System.out.println(naam1.equals(naam2));
        System.out.println(System.identityHashCode(naam1));
        System.out.println(System.identityHashCode(naam2));

        System.out.println("===========================");

        //twee strings met dezelfde inhoud EN verschillende reference
        String naam3 = "Jan";
        String naam4 = "Pan".replace("P", "J");

        System.out.println("naam3: " + naam3);
        System.out.println("naam4: " + naam4);

        System.out.println(naam3 == naam4);
        System.out.println(naam3.equals(naam4));
        System.out.println(System.identityHashCode(naam3));
        System.out.println(System.identityHashCode(naam4));

        System.out.println("===========================");

        //interning zorgt voor toevoeging aan de String pool
        naam4 = naam4.intern();

        System.out.println(naam3 == naam4);
        System.out.println(naam3.equals(naam4));
        System.out.println(System.identityHashCode(naam3));
        System.out.println(System.identityHashCode(naam4));

        System.out.println("===========================");

    }


}
