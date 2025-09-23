package java_vervolg;

public class InitializersExample {
    {
        System.out.println("Initializing");
    }

    static {
        System.out.println("static initializer example");
    }
    public InitializersExample() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        new InitializersExample();
    }
}
