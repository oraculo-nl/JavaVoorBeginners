package java_vervolg.oefeningen.oefening2;


// package nl.school.shapes;

public final class Triangle extends Shape {
    private final double a, b, c; // side lengths

    public Triangle(Point center, Color color, double a, double b, double c) {
        super(center, color);
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("sides must be > 0");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("triangle inequality violated");
        }
        this.a = a; this.b = b; this.c = c;
    }

    public double a() { return a; }
    public double b() { return b; }
    public double c() { return c; }

    @Override
    public double area() {
        double s = (a + b + c) / 2.0;
        return Math.sqrt(Math.max(0.0, s * (s - a) * (s - b) * (s - c))); // Heron's formula
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

    @Override
    protected String details() {
        return "Triangle a=" + a + ", b=" + b + ", c=" + c;
    }

    public Triangle withSides(double na, double nb, double nc) {
        return new Triangle(center, color, na, nb, nc);
    }
}
