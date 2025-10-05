package java_vervolg.part2;

public class Example26InterfaceMethods {
    static interface Greeter {
        // Abstract method (must be implemented by classes)
        void greet(String name);

        // Default method: has a body, can be overridden
        default void sayHello() {
            System.out.println("Hello from default method!");
            log("sayHello called"); // uses private helper
        }

        // Static method: belongs to the interface itself
        static void sayHi() {
            System.out.println("Hi from static method in interface!");
        }

        // Private method: helper for default methods (not visible to implementors)
        private void log(String msg) {
            System.out.println("[LOG] " + msg);
        }
    }

    static class EnglishGreeter implements Greeter {
        @Override
        public void greet(String name) {
            System.out.println("Hello, " + name + "!");
        }
    }

    public static void main(String[] args) {
        Greeter g = new EnglishGreeter();

        g.greet("Alice");   // abstract method implementation
        g.sayHello();       // default method (with private helper inside)

        Greeter.sayHi();    // static method called on the interface itself
    }
}

