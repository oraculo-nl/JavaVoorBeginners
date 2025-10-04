package java_vervolg.part2;

import java.io.*;

public class Example34EnumSerialisatie {

    enum Dag {
        MAANDAG, DINSDAG, WOENSDAG
    }


    public static void main(String[] args) throws Exception {
        Dag d = Dag.MAANDAG;

        File file = new File("dag.ser");
        System.out.println("Bestand komt hier terecht: " + file.getAbsolutePath());


                // Schrijf weg naar bestand
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(d);
        }

        // Lees terug
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            Dag gelezen = (Dag) in.readObject();
            System.out.println(gelezen); // -> MAANDAG
        }
    }
}

