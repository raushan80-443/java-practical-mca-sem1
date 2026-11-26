/*
 * Q13: Multithreading & Thread Pool Management
 * Question: Manage thread allocation efficiently using Java's Executor Service Framework and ExecutorService thread pool.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Task unit executed by a thread from the pool
class WorkerTask implements Runnable {
    private final int taskId;

    public WorkerTask(int id) {
        this.taskId = id;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " started by Thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(800); // Simulate work taking 800ms
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Task " + taskId + " completed by Thread: " + Thread.currentThread().getName());
    }
}

public class q13 {
    public static void main(String[] args) {
        // Create a fixed thread pool containing 3 reusable worker threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit 6 tasks: 3 run immediately, remaining 3 wait in the queue
        for (int i = 1; i <= 6; i++) {
            Runnable worker = new WorkerTask(i);
            executor.execute(worker);
        }

        // Stop accepting new tasks, but finish already-submitted ones
        executor.shutdown();
        while (!executor.isTerminated()) {
            // Wait until all queued tasks finish
        }
        System.out.println("All worker tasks completed successfully.");
    }
}
