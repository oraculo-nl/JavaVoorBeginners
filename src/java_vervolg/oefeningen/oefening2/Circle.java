package java_vervolg.oefeningen.oefening2;


// package nl.school.shapes;

public final class Circle extends Shape {
    private final double radius;

    public Circle(Point center, Color color, double radius) {
        super(center, color);
        if (radius <= 0) {
            throw new IllegalArgumentException("radius must be > 0");
        }
        this.radius = radius;
    }

    public double radius() { return radius; }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    protected String details() {
        return "Circle r=" + radius;
    }

    public Circle withRadius(double newRadius) {
        return new Circle(center, color, newRadius);
    }
}
