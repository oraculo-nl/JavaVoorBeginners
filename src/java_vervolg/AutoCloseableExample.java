package java_vervolg;

public class AutoCloseableExample implements AutoCloseable {
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
        try (AutoCloseableExample res = new AutoCloseableExample()) {
            res.use();
            System.out.println("inside try");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("after try-with-resources");
    }
}