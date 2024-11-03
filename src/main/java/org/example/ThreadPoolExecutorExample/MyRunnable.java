package org.example.ThreadPoolExecutorExample;

import java.util.List;

public class MyRunnable implements Runnable{

    List<Integer> myList;

    MyRunnable(List<Integer> list){
        this.myList = list;
    }

    @Override
    public void run() {
        myList.add(45);
        System.out.println("this is my runnable class to add the 45 in list");
    }
}
