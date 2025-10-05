package java_vervolg.part2;

public class Example25RecordInterface {
    // Define an interface
    static interface Shape {
        double area();
    }

    // Define a record that implements the interface
    static record Circle(double radius) implements Shape {
        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    }

    public static void main(String[] args) {
        Shape s = new Circle(5);  // Upcast to interface
        System.out.println("Area = " + s.area());
    }
}

