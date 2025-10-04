package java_vervolg.oefeningen.oefening2;


// package nl.school.shapes;

public interface Measurable {
    double area();
    double perimeter();

    default boolean isLarge(double threshold) {
        return area() >= threshold;
    }
}
