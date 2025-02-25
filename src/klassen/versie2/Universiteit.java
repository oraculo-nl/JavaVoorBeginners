package klassen.versie2;

public class Universiteit {
    public static void main(String[] args) {
        Studie st = new Studie();
        Student s1 = new Student();
        s1.setNaam("Alex Zhao");
        s1.studentNummer = 89789;
        Student s2 = new Student();
        s2.setNaam("Peter Roest");
        s2.studentNummer = 72642;
        st.studenten[0] = s1;
        st.studenten[1] = s2;


        for (var s : st.studenten) {
            if (s != null)
                System.out.println(s.getNaam() + " " + s.studentNummer);
        }

        st.vakken();
        var student = st.zoekStudent(89789);
        System.out.println(student.getNaam());
    }
}
