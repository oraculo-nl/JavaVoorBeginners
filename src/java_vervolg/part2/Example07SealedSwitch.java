package java_vervolg.part2;


/*

sealed (afgedekte) klassen en switch-statements werken samen om
 volledigheid te waarborgen bij het omgaan met alle mogelijke subtypes
 van een afgedekte klasse.

je kunt switch gebruiken op types met instanceof-achtige patronen.

Omdat de compiler precies weet dat Shape maar drie mogelijke subtypes heeft,
 kan hij controleren of je alle gevallen hebt afgedekt → dat
 heet exhaustiviteit.
*/
public class Example07SealedSwitch {
// File: SealedSwitchAbstract.java

    static abstract sealed class Shape
            permits Circle, Rectangle, Triangle {
    }

    static final class Circle extends Shape {
        final double r;

        Circle(double r) {
            this.r = r;
        }
    }

    static  final class Rectangle extends Shape {
        final double w, h;

        Rectangle(double w, double h) {
            this.w = w;
            this.h = h;
        }
    }

    static final class Triangle extends Shape {
        final double a, b, c;

        Triangle(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static String describe(Shape s) {
        return switch (s) {
            case Circle c -> "Circle radius=" + c.r;
            case Rectangle r -> "Rectangle " + r.w + "x" + r.h;
            case Triangle t -> "Triangle sides=" + t.a + "," + t.b + "," + t.c;
            // geen default nodig → compiler checkt exhaustiviteit
        };
    }

    public static void main(String[] args) {
        Shape s1 = new Circle(5);
        Shape s2 = new Rectangle(2, 4);
        Shape s3 = new Triangle(3, 4, 5);

        System.out.println(describe(s1));
        System.out.println(describe(s2));
        System.out.println(describe(s3));
    }
}

