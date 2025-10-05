package java_beginners.strings_en_input;

import java.util.Scanner;

public class Tafel {
    public static void main(String[] args) {
        var s = new Scanner(System.in);
        System.out.println("Voer een getal in:");
        var getal = s.nextInt();
        System.out.println("De tafel van "+getal+" is:");
        System.out.println("1 x "+getal+" = "+getal*1);
        System.out.println("2 x "+getal+" = "+getal*2);
        System.out.println("3 x "+getal+" = "+getal*3);
        System.out.println("4 x "+getal+" = "+getal*4);
        System.out.println("5 x "+getal+" = "+getal*5);
        System.out.println("6 x "+getal+" = "+getal*6);
        System.out.println("7 x "+getal+" = "+getal*7);
        System.out.println("8 x "+getal+" = "+getal*8);
        System.out.println("9 x "+getal+" = "+getal*9);
        System.out.println("10 x "+getal+" = "+getal*10);
    }
}
