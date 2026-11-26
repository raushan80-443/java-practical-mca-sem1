/*
 * Q03: Constructor Overloading and the this Keyword
 * Question: Demonstrate constructor overloading and the explicit usage of the 'this' keyword to differentiate instance variables from local parameters in Java.
 */

public class q3 {
    // Instance variables representing box dimensions
    private double width;
    private double height;
    private double depth;

    // 1. Default Constructor (0 args): creates a 1x1x1 unit box
    public q3() {
        this(1.0, 1.0, 1.0); // Constructor chaining: calls the 3-arg constructor
    }

    // 2. Cube Constructor (1 arg): all three sides are equal
    public q3(double side) {
        this(side, side, side); // Reuses the 3-arg constructor via this(...)
    }

    // 3. Parameterized Constructor (3 args): sets custom dimensions
    public q3(double width, double height, double depth) {
        // 'this' disambiguates instance variables from parameters with the same names
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    // Computes volume of the box
    public double getVolume() {
        return width * height * depth;
    }

    public static void main(String[] args) {
        // Each 'new q3(...)' invokes the matching overloaded constructor
        q3 defaultBox = new q3();
        q3 cube = new q3(5.0);
        q3 customBox = new q3(3.0, 4.0, 6.0);

        System.out.println("Default Box Volume : " + defaultBox.getVolume());
        System.out.println("Cube Volume        : " + cube.getVolume());
        System.out.println("Custom Box Volume  : " + customBox.getVolume());
    }
}
