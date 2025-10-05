package java_vervolg.part2;

public class Example09ToStringMethod {
    static class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Override van Object.toString()
        @Override
        public String toString() {
            return "Student{name='" + name + "', age=" + age + "}";
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Alice", 21);
        Student s2 = new Student("Bob", 23);

        // Zonder override zou dit zoiets printen als:
        // Student@1a2b3c
        System.out.println(s1);
        System.out.println(s2);
    }
}
