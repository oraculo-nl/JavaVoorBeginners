package java_vervolg.oefeningen.oefening2;


// package nl.school.shapes;

public record Point(int x, int y) {
    public Point {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Point coordinates must be >= 0");
        }
    }
}
