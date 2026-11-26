/*
 * Q08: Exception Handling Using try, catch, and finally
 * Question: Demonstrate structured exception handling in Java using try, multiple catch blocks, and execution of cleanup routines inside the finally block.
 */

public class q8 {
    public static void main(String[] args) {
        int[] numbers = { 10, 20, 30 };

        System.out.println("Starting Division Task Execution...");

        try {
            int num1 = numbers[1]; // Valid index (value = 20)
            int num2 = 0;

            // Dividing by zero throws ArithmeticException at runtime
            int result = num1 / num2;
            System.out.println("Result: " + result); // Skipped when exception occurs

        } catch (ArithmeticException e) {
            // Specific catch block for division by zero
            System.err.println("Error Handled: Arithmetic Division by Zero encountered.");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Specific catch block if an invalid array index is accessed
            System.err.println("Error Handled: Array index exceeded maximum capacity.");
        } catch (Exception e) {
            // Fallback catch-all (must come after specific exceptions)
            System.err.println("Generic Error Handled: " + e.getMessage());
        } finally {
            // Always runs whether an exception occurred or not (used for cleanup)
            System.out.println("Finally block executed. Resource cleanup complete.");
        }

        System.out.println("Program finished execution safely.");
    }
}
