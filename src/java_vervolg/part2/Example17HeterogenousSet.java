package java_vervolg.part2;

import java.util.*;

public class Example17HeterogenousSet {

    static abstract class Shape {
        abstract void draw();
    }

    static class Circle extends Shape {
        @Override
        void draw() {
            System.out.println("Drawing a circle");
        }
    }

    static class Rectangle extends Shape {
        @Override
        void draw() {
            System.out.println("Drawing a rectangle");
        }
    }

    public static void main(String[] args) {
        // A heterogeneous collection: all Shapes, but different subtypes
        Collection<Shape> shapes = new HashSet<>();
        shapes.add(new Circle());
        shapes.add(new Rectangle());

        // Polymorphism: each shape knows how to draw itself
        for (Shape s : shapes) {
            s.draw();
        }
    }
}

