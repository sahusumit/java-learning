package org.example.MultithreadingExample;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class SharedResources {
    Queue<Integer> sharedQueue;
    int bufferSize;

    public SharedResources(int bufferSize){
        sharedQueue = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void addItemInQueue(){
       // System.out.println("Producer is called to add item");
        while (sharedQueue.size() == bufferSize){
            try {
                System.out.println("Queue is full producer is waiting for consumer to consume");
                wait();
            }catch (Exception e){
                //System.out.println("queue is full producer is waiting");
            }
        }
            Random random = new Random();
            int val = random.nextInt();
            sharedQueue.add(val);
            System.out.println("Produced: "+ val+" bufferSize: "+ sharedQueue.size());
            notify();
    }

    public synchronized void consumedItemFromQueue(){
       // System.out.println("Consumer is called to remove item");
        while (sharedQueue.isEmpty()){
            try {
                System.out.println("Queue is empty Consumer is waiting for producer to add item in queue");
                wait();
            }catch (Exception e){
                //System.out.println("queue is full producer is waiting");
            }
        }

        int val =  sharedQueue.poll();
        System.out.println("Consumed Item: "+ val+ "  bufferSize: "+ sharedQueue.size());
        notify();
    }
}
