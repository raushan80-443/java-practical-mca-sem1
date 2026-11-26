/*
 * Q01: Find the Largest Element in an Array
 * Question: Write a Java program that finds and displays the maximum value stored within a single-dimensional array of integers.
 */

import java.util.Scanner; // Import Scanner to read input from the keyboard

public class q1 {
    public static void main(String[] args) {
        // Create Scanner object attached to standard input (System.in)
        Scanner scanner = new Scanner(System.in);

        // Read the size of the array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Allocate a 1D integer array of size n (indices 0 to n-1)
        int[] numbers = new int[n];
        System.out.println("Enter " + n + " integer values:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt(); // Store each input into index i
        }

        // Assume the first element is the largest (avoids bugs with negative numbers)
        int max = numbers[0];
        // Compare remaining elements (starting at index 1) against max
        for (int i = 1; i < n; i++) {
            if (numbers[i] > max) {
                max = numbers[i]; // Update max when a larger value is found
            }
        }

        System.out.println("The largest element in the array is: " + max);
        scanner.close(); // Close Scanner to release the input resource
    }
}
