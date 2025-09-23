package java_vervolg.part2;

// Abstracte superklasse

public class Example02AbstractClass {
    public static void main(String[] args) {
        // Shape s = new Shape();  // fout: abstracte klassen kun je niet instantieren

        Example02AbstractClass outer = new Example02AbstractClass();
        Shape c = outer.new Circle(2);
        c.describe();
        System.out.println("Circle area: " + c.area());
    }


    abstract class Shape {
        // abstracte methode (moet door subklassen geïmplementeerd worden)
        abstract double area();

        // gewone methode (mag door subklassen gebruikt worden zoals hij is)
        void describe() {
            System.out.println("I am a shape.");
        }
    }

    // Concreet: subklasse die Shape implementeert
    class Circle extends Shape {
        private double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        // implementatie van de abstracte methode
        @Override
        double area() {
            return Math.PI * radius * radius;
        }
    }

}
