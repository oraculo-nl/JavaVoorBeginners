package java_advanced.solutions;

public class Person {

    private String name;
    private int age;
    private String address;

    public Person name(String name) {
        this.name = name;
        return this;
    }

    public Person age(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age must be positive");
        }
        this.age = age;
        return this;
    }

    public Person address(String address) {
        this.address = address;
        return this;
    }

    public String name() {
        return name;
    }

    public String address() {
        return address;
    }

    public int age() {
        return age;
    }
}
