package java_vervolg.part2;

public class Example24SealedInterface {
    // Sealed interface: only Circle and Rectangle can implement Shape
    static sealed interface Shape permits Circle, Rectangle {
    }

    // Records implementing the sealed interface
    static record Circle(double radius) implements Shape {
    }

    static record Rectangle(double width, double height) implements Shape {
    }

    public static void main(String[] args) {
        Shape s1 = new Circle(5);
        Shape s2 = new Rectangle(2, 3);

        // Pattern matching switch knows all subtypes of Shape
        for (Shape s : new Shape[]{s1, s2}) {
            String desc = switch (s) {
                case Circle c -> "Circle with radius " + c.radius();
                case Rectangle r -> "Rectangle " + r.width() + " x " + r.height();
            };
            System.out.println(desc);
        }
    }
}

