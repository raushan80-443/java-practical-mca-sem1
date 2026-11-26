/*
 * Q12: Thread Inter-Process Communication (IPC): Producer-Consumer Synchronization
 * Question: Solve the classic Producer-Consumer problem in Java using wait(), notify(), and synchronized methods for thread inter-process communication.
 */

// Shared 1-slot buffer guarded by intrinsic monitor lock ('synchronized')
class SharedBuffer {
    private int data;
    private boolean empty = true; // State flag: true when buffer has no unread data

    public synchronized void produce(int value) {
        // Use 'while' (not 'if') to guard against spurious wakeups
        while (!empty) {
            try {
                wait(); // Release lock and wait until consumer empties the buffer
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.data = value;
        this.empty = false;
        System.out.println("PRODUCED: " + value);
        notify(); // Wake up waiting consumer thread
    }

    public synchronized int consume() {
        while (empty) {
            try {
                wait(); // Release lock and wait until producer puts data
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.empty = true;
        System.out.println("CONSUMED: " + data);
        notify(); // Wake up waiting producer thread
        return data;
    }
}

public class q12 {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        // Producer thread writes 1..5 into the shared buffer
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                buffer.produce(i);
                try { Thread.sleep(300); } catch (InterruptedException ignored) {}
            }
        });

        // Consumer thread reads 5 items from the shared buffer
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                buffer.consume();
                try { Thread.sleep(500); } catch (InterruptedException ignored) {}
            }
        });

        producer.start();
        consumer.start();
    }
}
