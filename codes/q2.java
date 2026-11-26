/*
 * Q02: Student Class with Constructors and Methods
 * Question: Design a Student class in Java incorporating instance variables, parameterized constructors, and methods to calculate total marks, percentage, and display student profiles.
 */

import java.util.Scanner;

public class q2 {
    // Private instance variables (encapsulation: each Student object has its own copy)
    private int rollNo;
    private String name;
    private double mark1, mark2, mark3;

    // Parameterized constructor to initialize all fields when creating a q2 (Student) object
    public q2(int rollNo, String name, double mark1, double mark2, double mark3) {
        // 'this.field' refers to the object's field; right-hand side is the parameter
        this.rollNo = rollNo;
        this.name = name;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    // Returns sum of the 3 subject marks
    public double calculateTotal() {
        return mark1 + mark2 + mark3;
    }

    // Computes percentage assuming each subject is out of 100
    public double calculatePercentage() {
        return calculateTotal() / 3.0;
    }

    // Prints formatted student profile and calculated results
    public void displayDetails() {
        System.out.println("----- Student Record -----");
        System.out.println("Roll Number : " + rollNo);
        System.out.println("Name        : " + name);
        System.out.println("Marks       : " + mark1 + ", " + mark2 + ", " + mark3);
        System.out.println("Total       : " + calculateTotal());
        System.out.printf("Percentage  : %.2f%%\n", calculatePercentage());
        System.out.println("--------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Roll Number: ");
        int roll = scanner.nextInt();
        scanner.nextLine(); // Consume leftover newline after nextInt() before nextLine()

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Marks for 3 Subjects: ");
        double m1 = scanner.nextDouble();
        double m2 = scanner.nextDouble();
        double m3 = scanner.nextDouble();

        // Instantiate q2 (Student) using the parameterized constructor
        q2 student = new q2(roll, name, m1, m2, m3);
        student.displayDetails();

        scanner.close();
    }
}
