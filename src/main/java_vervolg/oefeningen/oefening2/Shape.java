package java_vervolg.oefeningen.oefening2;


// package nl.school.shapes;

public sealed abstract class Shape implements Measurable permits Circle, Rectangle, Triangle {
    protected final Point center;
    protected final Color color;

    protected Shape(Point center, Color color) {
        if (center == null || color == null) {
            throw new IllegalArgumentException("center and color must not be null");
        }
        this.center = center;
        this.color = color;
    }

    public Point center() { return center; }
    public Color color() { return color; }

    // Template Method: final, roept details() aan voor subtype-specifiek deel
    public final String describe() {
        return "%s at %s | %s".formatted(color.label(), center, details());
    }

    protected abstract String details();

    @Override
    public abstract double area();

    @Override
    public abstract double perimeter();
}
