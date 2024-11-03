package org.example.JavaCollections.collectionClasses;

import java.util.LinkedList;

public class LinkedListExample {
    public void LinkedListMethods(){
        LinkedList<Integer> list = new LinkedList<>();
        //Using Deque functionality
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        System.out.println("first element of list: "+ list.getFirst());

        LinkedList<Integer> list2 = new LinkedList<>();
        //Using list functionality
        list2.add(0, 20);
        list2.add(1, 30);
        list2.add(2, 40);
        // 20->30->40
        list2.add(1, 50);
        // 20->50->30->40

        System.out.println(list2.get(1)+ " and "+ list2.get(2));



    }
}
