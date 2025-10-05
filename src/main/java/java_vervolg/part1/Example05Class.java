package java_vervolg.part1;

// Top-level class
public class Example05Class {

    private String top_level_var = "top level var";

    // Member class (non-static inner class)
    class MemberClass {
        void show() {
            System.out.println("Inside MemberClass");
            System.out.println(Example05Class.this.top_level_var);
        }
    }

    // Nested static class
    static class NestedStaticClass {
        void show() {
            System.out.println("Inside NestedStaticClass");
        }
    }

    public void demonstrateClasses() {
        // Local class (inside a method)
        class LocalClass {
            void show() {
                System.out.println("Inside LocalClass");
            }
        }
        LocalClass local = new LocalClass();
        local.show();

        // Anonymous class (no name, inline implementation)
        Runnable anonymous = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Anonymous Class");
            }
        };
        anonymous.run();
    }

    public static void main(String[] args) {
        // Top-level class is ClassExamples itself
        System.out.println("Inside Top-level Class");

        // Member (inner) class: needs an instance of outer class
        Example05Class outer = new Example05Class();
        MemberClass member = outer.new MemberClass();
        member.show();

        // Nested static class: can be created without outer instance
        NestedStaticClass nested = new NestedStaticClass();
        nested.show();

        // Local and anonymous classes demonstration
        outer.demonstrateClasses();
    }
}
