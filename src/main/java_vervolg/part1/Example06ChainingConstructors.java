package java_vervolg.part1;

public class Example06ChainingConstructors {
    public static void main(String[] args) {
        // Call the no-argument constructor
        Student student1 = new Student();
        student1.showInfo();

        System.out.println("-----");

        // Call the one-argument constructor
        Student student2 = new Student("Alice");
        student2.showInfo();

        System.out.println("-----");

        // Call the two-argument constructor
        Student student3 = new Student("Bob", 30);
        student3.showInfo();
    }
}

class Student {
    private String name;
    private int age;

    // No-argument constructor
    public Student() {
        this("Unknown"); // calls the constructor with one parameter
        System.out.println("No-arg constructor called");
    }

    // Constructor with one parameter
    public Student(String name) {
        this(name, 0); // calls the constructor with two parameters
        System.out.println("Constructor with one parameter called");
    }

    // Constructor with two parameters
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Constructor with two parameters called");
    }

    public void showInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

}
