package java_vervolg.part2;

public class Example20SwitchWithGuard {
    static sealed interface Shape permits Circle, Rectangle {
    }

    static record Circle(double r) implements Shape {
    }

    static record Rectangle(double w, double h) implements Shape {
    }

    public static void main(String[] args) {
        Shape s1 = new Circle(5);
        Shape s2 = new Circle(-1);
        Shape s3 = new Rectangle(2, 3);

        for (Shape s : new Shape[]{s1, s2, s3}) {
            String result = switch (s) {
                case Circle c when c.r() > 0 -> "Valid circle with radius " + c.r();
                case Circle c when c.r() <= 0 -> "Invalid circle (non-positive radius)";
                case Circle c -> "Circle with radius " + c.r();
                case Rectangle r -> "Rectangle " + r.w() + " x " + r.h();
                case null                     -> "Shape is null";
                //note that this case is exhaustive
            };
            System.out.println(result);
        }
    }
}

