package org.example.MultithreadingExample.PrintNumberInSequence;

public class PrintNumberInSequenceByThreadLock {
    private int number = 1; // Start number
    private final int max = 10; // End number
    private final Object lock = new Object();

    public void printOdd() {
        synchronized (lock) {
            while (number <= max) {
                if (number % 2 == 0) { // Wait if it's not an odd number
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Odd Thread: " + number++);
                    lock.notify(); // Notify the other thread
                }
            }
        }
    }

    public void printEven() {
        synchronized (lock) {
            while (number <= max) {
                if (number % 2 != 0) { // Wait if it's not an even number
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Even Thread: " + number++);
                    lock.notify(); // Notify the other thread
                }
            }
        }
    }
}





