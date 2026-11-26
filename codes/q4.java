/*
 * Q04: Method Overloading (Compile-Time Polymorphism)
 * Question: Demonstrate compile-time polymorphism by creating overloaded methods named 'area' to calculate the area of geometric shapes (Circle, Rectangle, and Triangle).
 */

public class q4 {

    // Overload 1 (1 parameter): Area of Circle = pi * r^2
    public double area(double radius) {
        return Math.PI * radius * radius;
    }

    // Overload 2 (2 parameters): Area of Rectangle = length * breadth
    public double area(double length, double breadth) {
        return length * breadth;
    }

    // Overload 3 (3 parameters): Area of Triangle = 0.5 * base * height
    // Extra boolean parameter distinguishes its signature from Rectangle's area(double, double)
    public double area(double base, double height, boolean isTriangle) {
        if (isTriangle) {
            return 0.5 * base * height;
        }
        return 0.0;
    }

    public static void main(String[] args) {
        q4 calc = new q4();

        // Compiler resolves which 'area' method to call at compile time based on arguments
        System.out.printf("Area of Circle (r = 4.5)      : %.2f\n", calc.area(4.5));
        System.out.printf("Area of Rectangle (5x8)       : %.2f\n", calc.area(5.0, 8.0));
        System.out.printf("Area of Triangle (b=6, h=10)  : %.2f\n", calc.area(6.0, 10.0, true));
    }
}
