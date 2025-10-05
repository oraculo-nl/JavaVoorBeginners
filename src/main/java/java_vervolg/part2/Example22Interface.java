package java_vervolg.part2;

public class Example22Interface {
    static interface Flyer {
        void fly();
    }

    static interface Swimmer {
        void swim();
    }

    // A Duck can both fly and swim
    static class Duck implements Flyer, Swimmer {
        @Override
        public void fly() {
            System.out.println("Duck is flying!");
        }

        @Override
        public void swim() {
            System.out.println("Duck is swimming!");
        }
    }

    public static void main(String[] args) {
        Duck d = new Duck();
        d.fly();
        d.swim();

        // We can also treat it as either interface
        Flyer f = d;     // upcast to Flyer
        Swimmer s = d;   // upcast to Swimmer

        f.fly();  // only flying is visible here
        s.swim(); // only swimming is visible here
    }
}

