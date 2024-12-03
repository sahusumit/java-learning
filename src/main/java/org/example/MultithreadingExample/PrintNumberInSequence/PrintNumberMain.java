package org.example.MultithreadingExample.PrintNumberInSequence;

public class PrintNumberMain {
    public static void main(String[] args) {
        PrintNumberInSequenceByThreadLock printNumbers = new PrintNumberInSequenceByThreadLock();

        Thread t1 = new Thread(printNumbers::printOdd);
        Thread t2 = new Thread(printNumbers::printEven);

        t1.start();
        t2.start();


        PrintNumberBySemaphore printNumberBySemaphore = new PrintNumberBySemaphore();
        Thread t1Semaphore = new Thread(printNumberBySemaphore::printOdd);
        Thread t2Semaphore = new Thread(printNumberBySemaphore::printEven);

        t1Semaphore.start();
        t2Semaphore.start();
    }
}

