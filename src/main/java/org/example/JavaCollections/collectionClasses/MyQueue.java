package org.example.JavaCollections.collectionClasses;

import java.util.*;

public class MyQueue {


    Queue<Integer> queue = new LinkedList<Integer>();



    public PriorityQueue<Integer> getMinPriorityQueue(){
        //By default it create the minHeap by default by we do not define any in the constructor
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        minPQ.add(5);
        minPQ.add(3);
        minPQ.add(8);
        minPQ.add(1);

        // to print all values in minPQ;
        minPQ.forEach((Integer val)-> System.out.println(val));

        //remove the value from the top and print that value;
        while (!minPQ.isEmpty()){
            int val = minPQ.poll();
            System.out.println("remove from top :"+ val);

        }
        return  minPQ;
    }


    public PriorityQueue<Integer> getMaxPriorityQueue(){
        // Max Priority queue, used to solve the problems of max heap;
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((Integer a, Integer b)->b-a);
        maxPQ.add(5);
        maxPQ.add(2);
        maxPQ.add(8);
        maxPQ.add(1);

        maxPQ.forEach((Integer value)-> System.out.println(value));

        //remove the value from the top and print that value;
        while(!maxPQ.isEmpty()){
            int value = maxPQ.poll();
            System.out.println("remove from top :"+ value);
        }
        return maxPQ;
    }


}
