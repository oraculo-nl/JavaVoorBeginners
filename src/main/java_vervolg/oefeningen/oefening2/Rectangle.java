package java_vervolg.oefeningen.oefening2;


// package nl.school.shapes;

public final class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(Point center, Color color, double width, double height) {
        super(center, color);
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("width and height must be > 0");
        }
        this.width = width;
        this.height = height;
    }

    public double width() { return width; }
    public double height() { return height; }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    protected String details() {
        return "Rectangle w=" + width + ", h=" + height;
    }

    public Rectangle withSize(double newWidth, double newHeight) {
        return new Rectangle(center, color, newWidth, newHeight);
    }
}
