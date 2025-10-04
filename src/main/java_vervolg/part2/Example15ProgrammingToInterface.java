package java_vervolg.part2;



/*
Programmeer tegen interface, niet implementatie

- Niet doen: je code afhankelijk maken van een concrete klasse
 (implementatie).

- Wel doen: je code schrijven tegen een interface of een abstract
 type.

- Zo kan je later makkelijk de implementatie vervangen of
uitbreiden zonder dat al je code moet worden aangepast.
*/

public class Example15ProgrammingToInterface {


    // Voorbeeld zonder interface (fout idee)

    static class MySqlDatabase {
        void save(String data) {
            System.out.println("Saving to MySQL: " + data);
        }
    }

    static class Service {
        private MySqlDatabase db = new MySqlDatabase(); // vastgeklonken

        void process(String data) {
            db.save(data); // kan *alleen* met MySQL
        }
    }

    //Voorbeeld mét interface (goed idee)

    static interface Database {
        void save(String data);
    }

    static class MySqlDatabase2 implements Database {
        public void save(String data) {
            System.out.println("Saving to MySQL: " + data);
        }
    }

    static class PostgresDatabase implements Database {
        public void save(String data) {
            System.out.println("Saving to PostgreSQL: " + data);
        }
    }

    static class Service2 {
        private Database db; // hangt af van interface

        Service2(Database db) {
            this.db = db;
        }

        void process(String data) {
            db.save(data); // maakt niet uit welke implementatie
        }
    }

    public static void main(String[] args) {
        Service s = new Service();
        s.process("Hello");

        Service2 s1 = new Service2(new MySqlDatabase2());
        s1.process("Hello");

        Service2 s2 = new Service2(new PostgresDatabase());
        s2.process("World");
    }
}
