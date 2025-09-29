package java_vervolg.part1;

public class Example07Initializers {
    {
        System.out.println("Initializing");
    }

    static {
        System.out.println("static initializer example");
    }
    public Example07Initializers() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        new Example07Initializers();
    }
}
