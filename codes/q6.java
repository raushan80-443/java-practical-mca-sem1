/*
 * Q06: Abstract Class and its Implementation
 * Question: Implement abstraction in Java using an abstract class Shape with concrete subclasses overriding abstract calculation methods.
 */

// Abstract class: cannot be instantiated directly with 'new Shape(...)'
abstract class Shape {
    protected String color;

    // Abstract classes can still have constructors (called via super() by subclasses)
    public Shape(String color) {
        this.color = color;
    }

    // Abstract methods: no body; every concrete subclass MUST implement them
    public abstract double calculateArea();
    public abstract double calculatePerimeter();

    // Concrete method: shared by all subclasses
    public void displayColor() {
        System.out.println("Shape Color: " + color);
    }
}

// Concrete subclass 1
class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color); // Initialize inherited 'color' in Shape
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Concrete subclass 2
class Rectangle extends Shape {
    private double width, height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
}

public class q6 {
    public static void main(String[] args) {
        // Polymorphic references of abstract type Shape
        Shape c = new Circle("Red", 3.5);
        Shape r = new Rectangle("Blue", 4.0, 7.0);

        c.displayColor();
        System.out.printf("Circle Area: %.2f | Perimeter: %.2f\n\n", c.calculateArea(), c.calculatePerimeter());

        r.displayColor();
        System.out.printf("Rectangle Area: %.2f | Perimeter: %.2f\n", r.calculateArea(), r.calculatePerimeter());
    }
}
