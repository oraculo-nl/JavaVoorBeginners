package java_vervolg.oefeningen.oefening2;


// package nl.school.shapes;

public final class ShapeUtils {
    private ShapeUtils() {}

    // Classification using pattern matching switch (JDK 21+)
    public static String classify(Shape s) {
        final double LARGE_AREA = 500.0;
        return switch (s) {
            case Circle c when c.isLarge(LARGE_AREA) -> "Large circle";
            case Circle c -> "Circle";
            case Rectangle r when r.isLarge(LARGE_AREA) -> "Large rectangle";
            case Rectangle r -> "Rectangle";
            case Triangle t when t.isLarge(LARGE_AREA) -> "Large triangle";
            case Triangle t -> "Triangle";
        };
    }

    // Pure functional scaling: returns NEW shapes (no mutation)
    public static Shape scale(Shape s, double factor) {
        if (factor <= 0) throw new IllegalArgumentException("factor must be > 0");
        return switch (s) {
            case Circle c -> new Circle(c.center(), c.color(), c.radius() * factor);
            case Rectangle r -> new Rectangle(r.center(), r.color(), r.width() * factor, r.height() * factor);
            case Triangle t -> new Triangle(t.center(), t.color(), t.a() * factor, t.b() * factor, t.c() * factor);
        };
    }

    public static Shape scale(Shape s, ScalePolicy policy) {
        if (policy == null) throw new IllegalArgumentException("policy must not be null");
        return scale(s, policy.factor());
    }
}
