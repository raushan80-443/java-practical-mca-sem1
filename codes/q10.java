/*
 * Q10: Creating Threads Using Thread and Runnable
 * Question: Demonstrate Java multithreading using both the extension of the Thread class and the implementation of the Runnable interface.
 */

// Approach 1: Extend the Thread class and override run()
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Thread Class Execution: Count " + i);
            try {
                Thread.sleep(500); // Pause for 500ms so threads interleave visibly
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

// Approach 2: Implement Runnable (preferred when class already extends another class)
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Runnable Task Execution: Count " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class q10 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();

        // Wrap the Runnable task inside a Thread object
        MyRunnable runnable = new MyRunnable();
        Thread t2 = new Thread(runnable);

        System.out.println("Starting Threads...");
        // Always call start() (not run()) to spawn new OS/JVM threads concurrently
        t1.start();
        t2.start();
    }
}
