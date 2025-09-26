package java_vervolg.oefeningen.oefening2;


// package nl.school.shapes;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = List.of(
            new Circle(new Point(10, 10), Color.RED, 10),
            new Rectangle(new Point(0, 0), Color.GREEN, 20, 10),
            new Triangle(new Point(5, 5), Color.BLUE, 10, 11, 12),
            new Circle(new Point(100, 100), Color.BLACK, 25),
            new Rectangle(new Point(50, 50), Color.WHITE, 40, 15)
        );

        for (Shape s : shapes) {
            System.out.println(s.describe());
            System.out.println("  area=" + Math.round(s.area()) +
                               ", perimeter=" + Math.round(s.perimeter()));
            System.out.println("  class: " + ShapeUtils.classify(s));

            Shape scaled = ShapeUtils.scale(s, ScalePolicy.HALF);
            System.out.println("  scaled(half): " + scaled.describe());
            System.out.println();
        }
    }
}
