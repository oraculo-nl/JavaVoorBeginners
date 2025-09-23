package java_vervolg.part2;

public class Example27InterfaceResolutionConflict {
    static interface A {
        default void hello() {
            System.out.println("Hello from A");
        }
    }

    static interface B {
        default void hello() {
            System.out.println("Hello from B");
        }
    }


/*
    static class C implements A, B {
        // Compilation error if we don’t resolve the conflict!
    }
*/

    static class C implements A, B {
        @Override
        public void hello() {
            // Explicit qualification
            A.super.hello(); // call A’s version
            B.super.hello(); // (optional) call B’s version too
            System.out.println("Hello from C");
        }
    }

    public static void main(String[] args) {
        new C().hello();
    }

}
