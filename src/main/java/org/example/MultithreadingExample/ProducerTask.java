package org.example.MultithreadingExample;

public class ProducerTask implements Runnable{

    SharedResources sharedResources;
    ProducerTask(SharedResources sharedResources){
        this.sharedResources = sharedResources;
    }


    @Override
    public void run() {
        System.out.println("Producer thread: "+ Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
          ///
        }
        for(int i=0; i<30; i++) {
            sharedResources.addItemInQueue();
        }
    }
}
