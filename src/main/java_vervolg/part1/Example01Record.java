package java_vervolg.part1;



public record Example01Record(String name, String address) {

    record Student(String name, int age) {
        public void aMethod() {
            System.out.println("aMethod called");
        }

        public Student {
            System.out.println("Compact constructor called");
        }


    }

    //constructor
    public Example01Record {
        System.out.println("Constructor called");
    }

    public static void main(String[] args) {
        var s1 = new Student("Jan", 24);
        var s2 = new Student("Jan", 24);

        System.out.println(s1.toString());
        System.out.println(s2);

        //inhoud is gelijk maar referentie niet
        System.out.println(s1.equals(s2));
        System.out.println(s1==s2);

        //de hashcodes reflecteren dit ook
        System.out.println(s1.hashCode() == s2.hashCode());
        System.out.println(System.identityHashCode(s1) == System.identityHashCode(s2));


        new Example01Record( "Jan", "Herengracht 1");

        s1.aMethod();
    }


}
