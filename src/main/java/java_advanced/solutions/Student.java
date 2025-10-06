package java_advanced.solutions;

import java.util.Optional;

public class Student extends Person{

    private String id;
    private String email;

    public Student() {
    }

    public Student(String name) {
        super.name(name);
    }

    public Student id(String id) {
        this.id = id;
        return this;
    }

    @Override
    public Student name(String name) {
        super.name(name);
        return this;
    }

    public Student email(String email) {
        this.email = email;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return super.name();
    }

}
