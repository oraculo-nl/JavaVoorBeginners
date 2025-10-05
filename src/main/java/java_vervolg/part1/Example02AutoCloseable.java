package java_vervolg.part1;

public class Example02AutoCloseable implements AutoCloseable {
    @Override
    public void close() {
        System.out.println("close() called");
    }

    public void use() {
        System.out.println("using resource");
    }
}

class Main {
    public static void main(String[] args) {
        try (Example02AutoCloseable res = new Example02AutoCloseable()) {
            res.use();
            System.out.println("inside try");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("after try-with-resources");
    }
}