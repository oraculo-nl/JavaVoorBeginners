package java_vervolg.part1;

public class BuilderExample {
    public static void main(String[] args) {
        //met normale class
        new User("Jan");
        new User("Jan", 55);

        //met builder
        new UserB.Builder().name("Jan").build();
        new UserB.Builder().name("Jan").age(55).build();

        //met record Builder
        new UserR.Builder().name("Jan").build();
        new UserR.Builder().name("Jan").age(55).build();

    }
}

//normale class met overloading explosie
class User {
    private int age;
    private String name, email, address;
    User(String name) {  }
    User(String name, int age) {  }
    User(String name, int age, String email) {  }
    User(String name, int age, String email, String address) {  }
    // enz...
}


//voorbeeld van een Builder class
class UserB {
    private final String name;
    private final int age;
    private final String email;
    private final String address;

    //gebruik van een private constructor
    private UserB(Builder b) {
        this.name = b.name;
        this.age = b.age;
        this.email = b.email;
        this.address = b.address;
    }

    //gebruik van een static inner class
    public static class Builder {
        private String name;
        private int age;
        private String email;
        private String address;

        public Builder name(String name) { this.name = name; return this; }
        public Builder age(int age) { this.age = age; return this; }
        public Builder email(String email) { this.email = email; return this; }
        public Builder address(String address) { this.address = address; return this; }

        public UserB build() { return new UserB(this); }
    }



}

//voorbeeld van een Builder class met record
record UserR(String name, int age, String email, String address) {
    // geen attributes en constructor nodig

    // Builder is static nested class
    public static class Builder {
        private String name;
        private int age;
        private String email;
        private String address;

        public Builder name(String name) { this.name = name; return this; }
        public Builder age(int age) { this.age = age; return this; }
        public Builder email(String email) { this.email = email; return this; }
        public Builder address(String address) { this.address = address; return this; }

        public UserR build() {
            return new UserR(name, age, email, address);
        }
    }
}

