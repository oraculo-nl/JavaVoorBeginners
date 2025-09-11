package java_vervolg;



public record RecordExample(String name, String address) {

    record Student(String name, int age) { }

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

    }
}
