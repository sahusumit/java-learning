package org.example.MultithreadingExample;

public class ConsumerTask  implements Runnable{
    SharedResources sharedResources;

    public ConsumerTask(SharedResources sharedResources){
        this.sharedResources = sharedResources;
    }

    @Override
    public void run() {
        System.out.println("Consumer Thread: " + Thread.currentThread().getName());
        for(int i=0; i<30; i++) {
            sharedResources.consumedItemFromQueue();
        }
    }
}
