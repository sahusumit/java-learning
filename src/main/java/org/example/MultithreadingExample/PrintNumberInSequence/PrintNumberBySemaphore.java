package org.example.MultithreadingExample.PrintNumberInSequence;

import java.util.concurrent.Semaphore;

public class PrintNumberBySemaphore {
    private final Semaphore semOdd = new Semaphore(1); // Initially available for Odd
    private final Semaphore semEven = new Semaphore(0); // Initially unavailable for Even
    private final int max = 10;

    public void printOdd() {
        for (int i = 1; i <= max; i += 2) {
            try {
                semOdd.acquire(); // Acquire permission for odd thread
                System.out.println("Odd Thread Semaphore: " + i);
                semEven.release(); // Release permission for even thread
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }

    public void printEven() {
        for (int i = 2; i <= max; i += 2) {
            try {
                semEven.acquire(); // Acquire permission for even thread
                System.out.println("Even Thread Semaphore: " + i);
                semOdd.release(); // Release permission for odd thread
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
