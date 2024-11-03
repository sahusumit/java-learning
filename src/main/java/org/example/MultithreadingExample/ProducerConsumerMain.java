package org.example.MultithreadingExample;

public class ProducerConsumerMain {
    public static void main(String args []){
        SharedResources sharedResources = new SharedResources(3);
        Thread producerThread  = new Thread(new ProducerTask(sharedResources));
        Thread consumerThread  = new Thread(new ConsumerTask(sharedResources));

        producerThread.start();
        consumerThread.start();

    }
}
