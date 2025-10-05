package java_vervolg.part2;


/*
Om clone() te kunnen gebruiken, moet je Cloneable implementeren.
Anders gooit super.clone() een CloneNotSupportedException.
super.clone() maakt een shallow copy: alle primitieve velden en
 referenties worden gekopieerd.

Voor diepe kopieën (bijv. als Student een List<Course> zou hebben) moet
 je in clone() handmatig ook die objecten klonen.

niet handig:
- deep copy nodig
- Cloneable en super.clone() nodig
- overriden bij inheritance

beter:
copy constructor: A(A a)
factory method: A copyOf(A a)

*/

public class Example11Clone {
    static class Student implements Cloneable {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Override clone()
        @Override
        public Student clone() {
            try {
                return (Student) super.clone(); // shallow copy
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(); // zou niet mogen gebeuren
            }
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', age=" + age + "}";
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Alice", 21);
        Student s2 = s1.clone(); // maakt een kopie

        System.out.println("Original: " + s1);
        System.out.println("Clone   : " + s2);
        System.out.println("s1 == s2? " + (s1 == s2)); // false, andere objecten
    }
}

