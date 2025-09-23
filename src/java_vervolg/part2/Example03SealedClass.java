package java_vervolg.part2;

// sealed superklasse
sealed class Shape permits Circle, Rectangle {
    // gemeenschappelijke methode
    public void describe() {
        System.out.println("I am a shape.");
    }
}

// subklasse: moet expliciet in permits genoemd zijn
// en moet sealed, final of non-sealed zijn
final class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }
}

// subklasse: mag ook abstract zijn
// non-sealed opens the inheritance chain again
non-sealed class Rectangle extends Shape {
    double width, height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
}

public class Example03SealedClass {
    public static void main(String[] args) {
        Shape s1 = new Circle(5);
        Shape s2 = new Rectangle(4, 3);

        s1.describe();
        s2.describe();
    }
}

